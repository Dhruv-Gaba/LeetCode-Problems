class Solution {
    Map<Integer,List<Integer>> adj=new HashMap<>();
    Map<Integer,Integer> outDegree=new HashMap<>();
    Map<Integer,Integer> inDegree=new HashMap<>();

    private int getStartNode(){
        int startNode=-1;
        for(Map.Entry<Integer,Integer> entry:outDegree.entrySet()){
            int node=entry.getKey();
            int degree=entry.getValue();
            if(degree-inDegree.getOrDefault(node,0)==1){
                return node;
            }
            if(degree>0){
                startNode=node;
            }
        }
        return startNode;
    }
    private void getEulerianPath(int startNode,List<Integer> eulerianPath){
        while(outDegree.getOrDefault(startNode,0)>0){
            outDegree.put(startNode,outDegree.get(startNode)-1);
            int nextNode=adj.get(startNode).get(outDegree.get(startNode));
            getEulerianPath(nextNode,eulerianPath);
        }
        eulerianPath.add(startNode);
    }
    public int[][] validArrangement(int[][] pairs) {
        for(int pair[]:pairs){
            int from=pair[0];
            int to=pair[1];
            adj.computeIfAbsent(from,k->new ArrayList<>()).add(to);
            outDegree.put(from,outDegree.getOrDefault(from,0)+1);
            inDegree.put(to,inDegree.getOrDefault(to,0)+1);
        }
        int startNode=getStartNode();

        List<Integer> eulerianPath=new ArrayList<>();
        getEulerianPath(startNode,eulerianPath);

        int[][] ans=new int[eulerianPath.size()-1][2];
        for(int i=eulerianPath.size()-1;i>0;i--){
            ans[eulerianPath.size()-1-i][0]=eulerianPath.get(i);
            ans[eulerianPath.size()-1-i][1]=eulerianPath.get(i-1);
        }
        return ans;
    }
}
