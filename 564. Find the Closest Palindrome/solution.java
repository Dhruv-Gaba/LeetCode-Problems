class Solution {
    public String nearestPalindromic(String n) {
        int len=n.length();
        int mid=len%2==0?(len/2)-1:len/2;
        Long firstHalf=Long.parseLong(n.substring(0,mid+1));

        List<Long> possibilities=new ArrayList<>();
        possibilities.add(halfToPalinedrome(firstHalf,len%2==0));
        possibilities.add(halfToPalinedrome(firstHalf+1,len%2==0));
        possibilities.add(halfToPalinedrome(firstHalf-1,len%2==0));
        possibilities.add((long)Math.pow(10,len)+1);
        possibilities.add((long)Math.pow(10,len-1)-1);

        long n1=Long.parseLong(n);
        long diff=Integer.MAX_VALUE;
        long res=0;
        for(long x:possibilities){
            if(x==n1)continue;
            if(diff>Math.abs(n1-x)){
                diff=Math.abs(n1-x);
                res=x;
            }
            else if(diff==Math.abs(n1-x)){
                res=Math.min(x,res);
            }
        }
        return String.valueOf(res);
    }
    private Long halfToPalinedrome(long left,boolean isEven){
        long res=left;
        if(!isEven){
            left/=10;
        }
        while(left>0){
            res=res*10+(left%10);
            left=left/10;
        }
        return res;
    }
}

//11    0 11 22 101 9
//101
//9
