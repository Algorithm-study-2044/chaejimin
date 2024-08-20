package codefile;
import java.util.*;


public class Solution863 {
	public static class Graph {
        private Map<Integer, List<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }


        public void addEdge(int src, int dest) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(src).add(dest);
            adjList.get(dest).add(src); 
        }

        public List<Integer> getNeighbors(int node) {
            return adjList.getOrDefault(node, new ArrayList<>());
        }
    }


    public static void convertTreeToGraph(TreeNode root, Graph graph) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            graph.addEdge(root.val, root.left.val); 
            convertTreeToGraph(root.left, graph);  
        }

        if (root.right != null) {
            graph.addEdge(root.val, root.right.val); 
            convertTreeToGraph(root.right, graph); 
        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Graph graph = new Graph();
        

        convertTreeToGraph(root, graph);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        

        queue.offer(target.val);
        visited.add(target.val);
        
        int currentDistance = 0;
        

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {

                List<Integer> result = new ArrayList<>();
                while (!queue.isEmpty()) {
                    result.add(queue.poll());
                }
                return result;
            }
            

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.getNeighbors(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            currentDistance++;
        }
        
        return new ArrayList<>(); 
    }
	
}
