class Solution {
    public boolean maxSubstringLength(String s, int k) {
        Map<Character,int[]> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,new int[]{i,i});
            }else{
                map.get(ch)[1]=i;
            }
        }
        int n=s.length();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.get(ch)[0]!=i){
                continue;
            }
            int left=map.get(ch)[0];
            int right=map.get(ch)[1];
            boolean isValid=true;
            for(int j=left;j<=right;j++){
                right=Math.max(right,map.get(s.charAt(j))[1]);
                if(map.get(s.charAt(j))[0]<left){
                    isValid=false;
                    break;
                }
            }
            if(right-left+1<n && isValid){
                list.add(new int[]{left,right});
            }
        }
        Collections.sort(list,(a,b)->(a[1]-b[1]));
        int count=0;
        int lastEnd=-1;
        for(int i=0;i<list.size();i++){
            if(lastEnd<list.get(i)[0]){
                count++;
                lastEnd=list.get(i)[1];
            }
        }
        return count>=k;
    }
}
