class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].length;j++){
                        if(color[graph[curr][j]]==-1){
                            int newColor=color[curr]==0?1:0;
                            color[graph[curr][j]]=newColor;
                            q.add(graph[curr][j]);
                        }else if(color[curr]==color[graph[curr][j]]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
