class Solution {
    public int beautySum(String s) {
        int count[]=new int[26];
        int max=0;
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<s.length();i++){
            Arrays.fill(count,0);
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                count[ch-'a']++;
                max=0;
                min=Integer.MAX_VALUE;
                for(int x:count){
                    if(x==0){
                        continue;
                    }
                    max=Math.max(max,x);
                    min=Math.min(min,x);
                }
                ans+=(max-min);
            }
        }
        return ans;
    }
}
