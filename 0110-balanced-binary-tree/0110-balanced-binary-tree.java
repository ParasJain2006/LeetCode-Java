/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1) return false;
        return true;
    }
    int height(TreeNode root){
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        if(left==-1 ||right==-1)return -1;
        int diff=left-right;
        if(diff>1 || diff<-1) return -1;
        return Math.max(right,left)+1;
    }
}