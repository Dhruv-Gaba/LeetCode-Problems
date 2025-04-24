class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(accounts.get(i).get(0).equals(accounts.get(j).get(0)) && isSame(i,j,accounts)){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        List<List<String>> ans=new ArrayList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(graph,i,visited,accounts,ans);
            }
        }
        return ans;
    }
    public void bfs(ArrayList<Integer>[] graph,int curr,boolean visited[],List<List<String>> accounts,List<List<String>> ans){
        Set<String> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        visited[curr]=true;
        while(!q.isEmpty()){
            int idx=q.remove();
            for(int i=1;i<accounts.get(idx).size();i++){
                set.add(accounts.get(idx).get(i));
            }
            for(int neigh:graph[idx]){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    q.add(neigh);
                }
            }
        }
        List<String> list=new ArrayList<>(set);
        Collections.sort(list);
        list.add(0,accounts.get(curr).get(0));
        ans.add(list);
    }
    public boolean isSame(int i,int j,List<List<String>> accounts){
        for(int k=1;k<accounts.get(i).size();k++){
            if(accounts.get(j).contains(accounts.get(i).get(k))){
                return true;
            }
        }
        return false;
    }
}
