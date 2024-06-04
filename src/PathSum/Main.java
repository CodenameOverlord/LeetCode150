package PathSum;

public class Main {
    public static void main(String[] args) {

    }

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


        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null && targetSum== 0){
                return false;
            }
            return recursiveLogic(root, targetSum);
        }

        boolean recursiveLogic(TreeNode root, int targetSum){
            if(root == null && targetSum== 0){
                return true;
            }
            if(root == null && targetSum !=0){
                return false;
            }
            if(root.left == null && root.right == null){
                return root.val == targetSum;
            }
            boolean val1 = false; boolean val2 = false;
            if(root.left!=null){
                val1 = recursiveLogic(root.left, targetSum - root.val);
            }
            if(root.right!=null){
                val2 = recursiveLogic(root.right, targetSum - root.val);
            }
            return val1 || val2;
        }

}
