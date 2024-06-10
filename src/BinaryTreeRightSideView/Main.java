package BinaryTreeRightSideView;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> allNodes = findLevelOrderTraversal(root);
        return findRightMost(allNodes);
    }

    List<Integer> findRightMost(List<Integer> allNodes){
        if(allNodes==null || allNodes.size()==0){
            return new ArrayList<>();
        }
        List<Integer> soln = new ArrayList<>();
        for(int i =1; i<allNodes.size();++i){
            if(allNodes.get(i)==null){
                soln.add(allNodes.get(i-1));
            }
        }
        return soln;
    }

    List<Integer> findLevelOrderTraversal(TreeNode root){
        Queue<TreeNode> store = new LinkedList<>();
        List<Integer> soln = new ArrayList<>();
        if(root == null){
            return soln;
        }
        store.add(root);
        store.add(null);
        while(store.size()>1){
            TreeNode current = store.remove();
            if(current!=null){
                if(current.left!=null) store.add(current.left);
                if(current.right!=null) store.add(current.right);
                soln.add(current.val);
            }
            else{
                soln.add(null);
                store.add(null);
            }
        }
        if(!soln.isEmpty())soln.add(null);
        return soln;
    }
}
