package InorderTree;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> solutionList = new ArrayList<>();
        inorder(solutionList, root);
        return solutionList;
    }

    public void inorder(List<Integer> result, TreeNode root){
        if(root != null){
            inorder(result, root.left);
            result.add(root.val);
            inorder(result, root.right);
        }
    }
}
