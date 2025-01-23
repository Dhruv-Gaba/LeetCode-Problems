class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Map<Integer,List<Integer>> rows=new HashMap<>();
        Map<Integer,Integer> cols=new HashMap<>();
        for(int i=0;i<m;i++){
            rows.put(i,new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rows.get(i).add(j);
                    cols.put(j,cols.getOrDefault(j,0)+1);
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            if(rows.get(i).size()>1){
                count+=rows.get(i).size();
            }
            else if(rows.get(i).size()==1){
                if(cols.get(rows.get(i).get(0))>1){
                    count++;
                }
            }
        }
        return count;
    }
}
