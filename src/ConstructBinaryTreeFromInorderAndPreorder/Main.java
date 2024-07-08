package ConstructBinaryTreeFromInorderAndPreorder;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i =0; i< inorder.length;++i){
            inorderMap.put(inorder[i], i);
        }
        int preLeft = 0;
        int preRight = preorder.length-1;
        int inLeft = 0;
        int inRight = inorder.length-1;
        return buildTree(preorder, preLeft, preRight, inorder, inLeft, inRight, inorderMap);
    }

    TreeNode buildTree(int [] preorder, int preLeft, int preRight,
                       int [] inorder, int inLeft, int inRight, Map<Integer, Integer> inorderMap){
        //base case
        if(inLeft>inRight || preLeft>preRight)
            return null;
        // create root node
        TreeNode root = new TreeNode(preorder[preLeft]);
        //find the position of rootNode in inorder tree
        int posRootInorder = inorderMap.get(root.val);
        // find the number of nodes in leftSubTree
        int nodesInLst = posRootInorder - inLeft;

        root.left = buildTree(preorder, preLeft+1, preLeft+nodesInLst,
                inorder, inLeft, posRootInorder-1,
                inorderMap);
        root.right = buildTree(preorder, preLeft+nodesInLst+1, preRight,
                inorder, posRootInorder+1, inRight,
                inorderMap);
        return root;
    }
}
