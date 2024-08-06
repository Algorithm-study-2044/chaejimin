package codefile;

public class Solution1791 {
	public int findCenter(int[][] edges) {
        int m = edges.length;
        int[] arr = new int[m+2];
        
        for (int i = 0; i<m; i++) {
        	arr[edges[i][0]]++;
        	arr[edges[i][1]]++;
        }
        
        int answer = 0;
        
        for (int i = 1; i<arr.length; i++) {
        	if (arr[i]==m) {
        		answer = i;
        	}
        }
        return answer;
    }
}
