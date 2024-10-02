class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp=Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        Map<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i=0;i<temp.length;i++){
            if(i>0 && temp[i]==temp[i-1]){
                continue;
            }
                map.put(temp[i],rank);
                rank++;
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
