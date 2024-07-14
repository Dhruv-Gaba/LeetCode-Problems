class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        Integer[] indices=new Integer[n];
        for(int i=0;i<n;i++){
            indices[i]=i;
        }
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        Arrays.sort(
            indices, 
            (lhs,rhs)->Integer.compare(positions[lhs],positions[rhs])
        );
        for(int i:indices){
            if(directions.charAt(i)=='R'){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && healths[i]!=0){
                    int topidx=stack.pop();
                    if(healths[i]==healths[topidx]){
                        healths[i]=0;
                        healths[topidx]=0;
                    }
                    else if(healths[i]>healths[topidx]){
                        healths[topidx]=0;
                        healths[i]-=1;
                    }
                    else{
                        healths[i]=0;
                        healths[topidx]-=1;
                        stack.push(topidx);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]!=0){
                list.add(healths[i]);
            }
        }
        return list;
    }
}
