package codefile;

import java.util.HashMap;

public class Solution501 {
	HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
	
	public int[] findMode(TreeNode root) {
		int maxCount = 0;
		int count = 0;
		inOrder(root);
		for (int i : h1.keySet()) {
			if(h1.get(i) > maxCount) {maxCount = h1.get(i);}
		}
		for (int i : h1.keySet()) {
			if(h1.get(i) == maxCount) {count += 1;}
		}
		int[] arr = new int[count];
		for (int i : h1.keySet()) {
			if(h1.get(i) == maxCount) {
				for(int j = count-1; j > 0; j--) {
					arr[j] = arr[j-1];
				}
				arr[0]= i;
			}
		}
		return arr;
	}
	
	private void inOrder(TreeNode root) {
		if(root.left != null) {inOrder(root.left);}
		if(h1.containsKey(root.val) == true) {
			h1.put(root.val, h1.get(root.val)+1);
		}else {
			h1.put(root.val, 1);
		}
		if(root.right != null) {inOrder(root.right);}
	}
}
