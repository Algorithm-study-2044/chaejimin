package codefile;

import java.lang.Math;

public class Solution104 {
	public int maxDepth(TreeNode root) {
        if (root == null) {return 0;}
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }
}
