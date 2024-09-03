class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(Integer.toString(s.charAt(i)-'a'+1));
        }
        int sum=0;
        s=sb.toString();
        while(k>0){
            sum=0;
            for(int i=0;i<s.length();i++){
                sum+=(s.charAt(i)-'0');
            }
            s=Integer.toString(sum);
            k--;
        }
        return sum;
    }
}
