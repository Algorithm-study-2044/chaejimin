package codefile;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
        	return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.right = left;
        root.left = right;
        
    	return root;
    }
    
}
