package codefile;

public class Solution1971 {
	int[] parent;
	
	private int find(int x) {
		if (parent[x] == x) {return x;}
		else return find(parent[x]);
	}
	
	private void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) {
			return;
		}else {
			if(x > y) {parent[x] = y;}
			else parent[y] = x;
			return;
		}
	}
	
	public boolean validPath(int n, int[][] edges, int sorce, int destination) {
		parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			union(a, b);
		}
        return find(sorce) == find(destination);
	}
}
