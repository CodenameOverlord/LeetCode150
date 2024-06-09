package SumRootToLeafNumbers;

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

    public int sumNumbers(TreeNode root) {

        List<String> left =  gatherInfo(root.left);
        List<String> right = gatherInfo(root.right);

        return computeVal(root.val, left, right);
    }

    int computeVal(Integer rootVal, List<String> left, List<String> right){
        if(left==null && right==null){
            return rootVal;
        }
        int leftSum = 0; int rightSum = 0;
        if(left!=null){
            leftSum = appendAndAdd(rootVal, left);
        }
        if(right!=null){
            rightSum = appendAndAdd(rootVal, right);
        }
        return leftSum+rightSum;
    }


    int appendAndAdd(Integer rootVal, List<String> s){
        int ans = 0;
        for(int i = 0; i< s.size(); ++i){
            ans += Integer.parseInt(rootVal+s.get(i));
        }
        return ans;
    }

    public List<String> gatherInfo(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right ==null){
            List<String> ans =  new ArrayList<>();
            ans.add(root.val+"");
            return ans;
        }
        List<String> left = null;
        List<String> right = null;
        if(root.left!=null){
            left = gatherInfo(root.left);
        }
        if(root.right!=null){
            right = gatherInfo(root.right);
        }

        return collect(root.val, left, right);
    }

    List<String> collect(Integer rootVal, List<String> left, List<String> right){
        List<String> ans = new ArrayList<>();
        addToList(ans, rootVal,  left);
        addToList(ans, rootVal, right);
        return ans;
    }

    void addToList(List<String> ans, int rootVal, List<String>list){
        if(list!=null)
            for(int i =0; i< list.size(); ++i){
                ans.add(rootVal+list.get(i));
            }
    }
}
