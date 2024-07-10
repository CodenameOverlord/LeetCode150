package ConstructBinaryTreeFromPostOrderInorderTraversal;

import java.util.HashMap;
import java.util.Map;
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i =0; i< inorder.length;++i){
            inorderMap.put(inorder[i],i);
        }
        int inorderLeft=0,postorderLeft =0, inorderRight=inorder.length-1, postorderRight=inorder.length-1;
        return buildTree(inorder, inorderLeft, inorderRight,
                postorder, postorderLeft, postorderRight,
                inorderMap);
    }

    TreeNode buildTree(int [] inorder, int inorderLeft, int inorderRight,
                       int postorder[] , int postorderLeft, int postorderRight,
                       Map<Integer, Integer> inorderMap){

        if(inorderLeft>inorderRight || postorderLeft>postorderRight)
            return null;

        TreeNode root = new TreeNode (postorder[postorderRight]);
        int inorderRootPos = inorderMap.get(root.val);
        int numNodesRight = inorderRight-inorderRootPos;
        int newPostOrderLeftMostNode = postorderRight-numNodesRight;
        root.right = buildTree(inorder, inorderRootPos+1, inorderRight,
                postorder, newPostOrderLeftMostNode,postorderRight-1,
                inorderMap
        );

        root.left = buildTree(inorder, inorderLeft, inorderRootPos-1,
                postorder,postorderLeft, newPostOrderLeftMostNode-1,
                inorderMap);

        return root;
    }
}
