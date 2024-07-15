package BinaryTreeZigZagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
      public class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> solnList = new ArrayList<>();
        q.add(root);q.add(null);
        List<Integer> current = new ArrayList<>();

        while(q.size()>1){
            TreeNode x = q.remove();
            if(x==null){
                q.add(null);
                solnList.add(current);
                current = new ArrayList<>();
            }
            else{
                current.add(x.val);
                if(x.left!=null){q.add(x.left);}
                if(x.right!=null){q.add(x.right);}
            }
        }

        solnList.add(current);

        reverseAlternateListInList(solnList);
        return solnList;
    }

    void reverseAlternateListInList(List<List<Integer>> solnList){
        boolean flip = false;
        for(int i =0; i< solnList.size();++i){
            if(i%2==1){
                reverseList(solnList.get(i));
            }
        }
    }

    void reverseList(List<Integer> a){
        for(int i =0; i< a.size()/2;++i){
            int temp = a.get(i);
            a.set(i, a.get(a.size()-1-i));
            a.set(a.size()-1-i,temp);
        }
    }
}
