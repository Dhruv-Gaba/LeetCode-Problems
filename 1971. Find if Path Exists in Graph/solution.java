class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<Integer> s = new ArrayList<>();
        s.add(source);
        for (int i = 0; i < s.size(); i++) {
            source = s.get(i);
            for (int j = 0; j < edges.length; j++) {
                if ((edges[j][0] == source && edges[j][1] == destination)
                        || (edges[j][1] == source && edges[j][0] == destination)) {
                    return true;
                }
                if (edges[j][0] == source || edges[j][1] == source) {
                    int s1 = source == edges[j][0] ? edges[j][1] : edges[j][0];
                    edges[j][0] = -1;
                    edges[j][1] = -1;
                    if(!s.contains(s1)){
                        s.add(s1);
                    }
                }
            }
        }
        return false;
    }
}
