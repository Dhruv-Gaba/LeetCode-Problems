class Solution {
    public boolean isHappy(int n) {
        int num=0;
        List<Integer> list=new ArrayList<Integer>();  
        while(n!=1){
            if(list.contains(n)){
                return false;
            }
            list.add(n);
            num=0;
            while(n>0){
                int rem=n%10;
                num+=rem*rem;
                n/=10;
            }
            n=num;
        }
        return true;
    }
}
