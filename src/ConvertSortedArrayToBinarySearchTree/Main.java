package ConvertSortedArrayToBinarySearchTree;

public class Main {
    public static void main(String[] args) {

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
    public static TreeNode sortedArrayToBST(int[] nums) {
        return formBST(nums,0, nums.length-1);
    }
    static TreeNode formBST(int [] nums, int start, int end){
        if(start>end){
            return null;
        }
        else{
            int mid = (start+end)/2;
            TreeNode current = new TreeNode(nums[mid]);
            current.left = formBST(nums, start, mid-1);
            current.right = formBST(nums, mid+1, end);
            return current;
        }
    }
}
