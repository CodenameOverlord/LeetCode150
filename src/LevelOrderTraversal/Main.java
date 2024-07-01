package LevelOrderTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode ls = new TreeNode(20);
        ls.left = new TreeNode(15);
        ls.right = new TreeNode (7);
        root.right = ls;
        levelOrder(new TreeNode(12));
    }
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> soln = new ArrayList<>();

        if(root==null){
            return soln;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);q.add(null);
        List<Integer> current = new ArrayList<>();
        while(q.size()>1){
            TreeNode x = q.remove();
            if(x==null){
                // q.remove();
                q.add(null);
                soln.add(current);
                current = new ArrayList<>();
            }
            else{
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
                current.add(x.val);
            }
        }
        soln.add(current);
        return soln;
    }
}
