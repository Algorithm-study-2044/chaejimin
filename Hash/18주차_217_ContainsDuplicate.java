package codefile;

import java.util.Hashtable;

public class Solution217 {
	public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	if(ht.containsKey(nums[i])) {
        		return true;
        	}else {
        		ht.put(nums[i], 1);
        	}
        }
        return false;
    }
}
