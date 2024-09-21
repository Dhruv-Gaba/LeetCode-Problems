class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=9;i++){
            generate(result,n,i);
        }
        return result;
    }
    private void generate(List<Integer> result,int n,int start){
        if(start>n)return;

        result.add(start);
        for(int nextDigit=0;nextDigit<=9;nextDigit++){
            int nextNum=start*10+nextDigit;
            if(nextNum<=n){
                generate(result,n,nextNum);
            }
            else{
                break;
            }
        }
    }
}
