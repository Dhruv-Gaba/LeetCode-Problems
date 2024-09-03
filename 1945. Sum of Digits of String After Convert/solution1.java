class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a'+1;
            while(temp>0){
                int rem=temp%10;
                temp/=10;
                sum+=rem;
            }
        }
        k--;
        int num=sum;
        while(k>0){
            sum=0;
            while(num>0){
                int rem=num%10;
                num/=10;
                sum+=rem;
            }
            num=sum;
            k--;
        }
        return sum;
    }
}
