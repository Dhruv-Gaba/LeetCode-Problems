class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,String> map=new HashMap<>();
        int n=score.length;
        Integer arr[]=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=score[i];
        }
        Arrays.sort(arr,Collections.reverseOrder());
        map.put(arr[0],"Gold Medal");
        if(n>=2){
            map.put(arr[1],"Silver Medal");
        }
        if(n>=3){
            map.put(arr[2],"Bronze Medal");
        }
        for(int i=3;i<n;i++){
            map.put(arr[i],Integer.toString(i+1));
        }
        String ans[]=new String[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(score[i]);
        }
        return ans;
    }
}
