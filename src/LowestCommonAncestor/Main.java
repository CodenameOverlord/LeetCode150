package LowestCommonAncestor;

public class Main {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String pSide = findSide(root, p);
        String qSide = findSide(root, q);
        if("left".equals(qSide) && "left".equals(pSide)){
            return lowestCommonAncestor(root.left, p,q);
        }
        else if("right".equals(qSide) && "right".equals(pSide)){
            return lowestCommonAncestor(root.right, p,q);
        }
        else
            return root;
    }

    String findSide(TreeNode root, TreeNode target){
        if(root==null || root==target){
            return null;
        }
        if(isPresent(root.left, target)){
            return "left";
        }
        else{
            return "right";
        }
    }

    boolean isPresent(TreeNode root, TreeNode target){
        if(root==null){
            return false;
        }
        if(root==target){
            return true;
        }
        else{
            return isPresent(root.left, target) || isPresent(root.right, target);
        }
    }
}
