public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    boolean cycleFound = false;

    public boolean validTree(int n, int[][] edges) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            map.computeIfAbsent(x, (z) -> new ArrayList()).add(y);
            map.computeIfAbsent(y, (z) -> new ArrayList()).add(x);
        }

        Set<Integer> visited = new HashSet();

        visit(0, -1, map, visited);
        if (cycleFound) return false;

        for(int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                return false;   
            }
        }

        return true;
    }

    void visit(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(node)) {
            cycleFound = true;
            return;
        }
        visited.add(node);
        
        List<Integer> nbs = map.get(node);
        if (nbs == null) return;
        for(int nb: nbs) {
            if (nb == parent) continue; // We do not go to the immediate parent
            visit(nb, node, map, visited);
        }
    }
}

/*
v = {0, 1}
    0 --- 1
          |
    3-----2
*/
