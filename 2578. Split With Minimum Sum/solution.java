class Solution {
    public int splitNum(int num) {
        String number=Integer.toString(num);
        StringBuilder num1=new StringBuilder();
        StringBuilder num2=new StringBuilder();
        char s[]=number.toCharArray();
        Arrays.sort(s);
        int n=s.length;
        for(int i=0;i<n;i++){
            if(i%2!=0){
                num1.append(s[i]);
            }else{
                num2.append(s[i]);
            }
        }
        return Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString());
    }
}
