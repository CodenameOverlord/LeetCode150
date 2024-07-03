public class kthSmallestElementInABst {
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

    int count =0;
    int pos =0;
    int element = 0;
    public int kthSmallest(TreeNode root, int k) {
        pos = k;
        inorder(root);
        return element;
    }

    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(count == pos ){
            return;
        }
        count++;
        if(count==pos)
        {element = root.val;
            return;}
        inorder(root.right);
    }
}
