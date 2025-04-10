class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int indeg[]=new int[numCourses];
        for(int x[]:prerequisites){
            graph[x[1]].add(x[0]);
            indeg[x[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            ans[i]=curr;
            i++;
            for(int neighbour:graph[curr]){
                indeg[neighbour]--;
                if(indeg[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        return i==numCourses?ans:new int[]{};
    }
}
