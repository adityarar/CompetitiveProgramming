public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            map.computeIfAbsent(x, (z) -> new ArrayList()).add(y);
            map.computeIfAbsent(y, (z) -> new ArrayList()).add(x);
        }

        int count = 0;
        Set<Integer> visited = new HashSet();

        for (int node=0; node<n; node++) {
            if(visited.contains(node)) continue;
            count++;
            visit(node, -1, map, visited);
        }

        return count;

    }

    void visit(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        
        if (!map.containsKey(node)) return; // Standalone node
        // Visit all neighbors
        for (int nb: map.get(node)) {
            if (nb == parent) continue; //Ignore immediate parent
            visit(nb, node, map, visited);
        }
    }
}

/*
1---2---3   4---5---6  0
|       |
7-------|
*/


