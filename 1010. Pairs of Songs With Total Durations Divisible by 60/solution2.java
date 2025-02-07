class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // Map<Integer,Integer> map=new HashMap<>();
        // int n=time.length;
        // int count=0;
        // for(int i=0;i<n;i++){
        //     if(time[i]%60==0){
        //         if(map.containsKey(0)){
        //             count+=map.get(0);
        //         }
        //     }
        //     else if(map.containsKey(60-(time[i]%60))){
        //         count+=map.get(60-(time[i]%60));
        //     }
        //     map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        // }
        // return count;

        int remainders[]=new int[60];
        int n=time.length;
        int count=0;
        for(int i=0;i<n;i++){
            count+=remainders[time[i]%60==0?0:60-(time[i]%60)];
            remainders[time[i]%60]++;
        }
        return count;
    }
}
