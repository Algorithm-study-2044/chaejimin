package codefile;

import java.util.HashMap;

class Solution997 {
    
	HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
	
	public int findJudge(int n, int[][] trust) {
        for (int i = 0; i < trust.length; i++) {
        	if (list.containsKey(trust[i][1])) {
        		list.put(trust[i][1], list.get(trust[i][1])+1);
        	} else {
        		list.put(trust[i][1], 1);
        	}
        }
		
        for (int i : list.keySet()) {
        	if (list.get(i).equals(n-1)) {
        		for (int j = 0; j < trust.length; i++) {
        			if(trust[j][0] == i) return -1;
        		}
        		return i;
        	}
        }
        return -1;
		
    }
    
	
	
}
