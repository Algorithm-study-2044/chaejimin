package codefile;

public class Solution1337 {
	int[] soldiers;
    int[] idx;
    int[] result;
    
	public int[] kWeakestRows(int[][] mat, int k) {
        
		soldiers = new int[mat.length];
		idx = new int[mat.length];
		
        for (int i = 0; i < mat.length; i++){
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++){
                sum += mat[i][j];
            }
            soldiers[i] = sum;
            idx[i] = i;
        }
        
        for(int i = 0; i < mat.length; i++) {
        	for (int j = mat.length - 1; j > i; j--) {
        		if (soldiers[j] < soldiers[j-1]) {
        			swap(j, j-1);
        		}
        	}
        }
        result = new int[k];
        for(int i = 0; i < k; i++) {
        	result[i] = idx[i];
        }
        return result;
        
    }
	public void swap(int i , int j) {
		int temp;
		temp = soldiers[i];
		soldiers[i] = soldiers[j];
		soldiers[j] = temp;
		
		temp = idx[i];
		idx[i] = idx[j];
		idx[j] = temp;
	}
	
	
}
