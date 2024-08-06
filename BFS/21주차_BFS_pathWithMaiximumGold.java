package codefile;


public class Solution1219 {
	
	class Solution {
	    public int calcPath(int m, int n, int grid[][], boolean flag[][], int i, int j) {
	        if (i >= m || j >= n || 0 > i || 0 > j || grid[i][j] == 0 || flag[i][j] == true) {
	            return 0;
	        }

	        flag[i][j] = true;

	        int topMax = calcPath(m, n, grid, flag, i - 1, j);
	        int rightMax = calcPath(m, n, grid, flag, i, j + 1);
	        int bottomMax = calcPath(m, n, grid, flag, i + 1, j);
	        int leftMax = calcPath(m, n, grid, flag, i, j - 1);

	        flag[i][j] = false;

	        int max = topMax;
	        if (rightMax > max) {
	            max = rightMax;
	        }

	        if (bottomMax > max) {
	            max = bottomMax;
	        }
	        
	        if (leftMax > max) {
	            max = leftMax;
	        }
	        return grid[i][j] + max;
	    }

	    public int getMaxGold(int m, int n, int grid[][], boolean flag[][]) {
	        int maxGold = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                maxGold = Math.max(maxGold, calcPath(m, n, grid, flag, i, j));
	            }
	        }
	        return maxGold;
	    }

	    public int gridWithNoZeros(int[][] grid, int m, int n){
	        int count = 0;
	        for(int i = 0; i < m; i++){
	            for (int j = 0; j < n; j++){
	                if(grid[i][j] == 0){
	                    return -1;
	                }else
	                    count += grid[i][j];
	                }
	            }
	        return count;
	    }  

	    public int getMaximumGold(int[][] grid) {
	        int m = grid.length, n = grid[0].length;
	        boolean flag[][] = new boolean[m][n];

	        int count = gridWithNoZeros(grid, m, n);
	        if(count != -1) return count;

	        return getMaxGold(m, n, grid, flag);
	    }
	}
	
}
