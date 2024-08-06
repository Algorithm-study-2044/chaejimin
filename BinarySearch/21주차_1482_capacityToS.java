package codefile;

public class Solution1482 {
	 public int minDays(int[] bloomDay, int m, int k) {
	        int n = bloomDay.length;
	        if ((long)m * k > n)  return -1;
	        
	        int high = 0;
	        for (int day : bloomDay)  if (day > high)  high = day;
	        int low = 0;
	        while (low < high) {
	            int mid = low + (high - low) / 2;
	            boolean isValid = tryDays(bloomDay, mid, m, k);
	            if (isValid) 
	                high = mid;
	            else 
	                low = mid + 1;
	        }
	        return low;
	    }
	    
	    
	  
	    private boolean tryDays(int[] bloomDay, int day, int m, int k) {
	        int idx = bloomDay.length - 1;
	        while (idx >= 0 && day < bloomDay[idx])  idx--;
	        if (idx < 0)  return false;
	        
	        while (true) {

	            int startGood = idx--;
	            while (idx >= 0 && day >= bloomDay[idx])  idx--;
	            m -= (startGood - idx) / k;
	            if (m <= 0)  return true;
	            if (idx < 0 || idx / k < m)  return false;


	            while (idx >= 0 && day < bloomDay[idx])  idx--;
	            if (idx < 0)  return false;
	        }
	    }
}
