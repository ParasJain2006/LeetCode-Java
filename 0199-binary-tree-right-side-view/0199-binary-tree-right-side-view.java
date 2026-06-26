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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> store= new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        store.add(root);
        while(!store.isEmpty()){
            int size=store.size();
            for(int i=0;i<size;i++){
                TreeNode temp=store.poll();
                if(i==size-1) ans.add(temp.val);
                if(temp.left!=null) store.add(temp.left);
                if(temp.right!=null) store.add(temp.right);
            }
        }
        return ans;
    }
}