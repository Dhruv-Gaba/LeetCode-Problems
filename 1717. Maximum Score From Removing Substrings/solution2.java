class Solution {
    public int maximumGain(String s, int x, int y) {
        int score=0;
        StringBuilder sb=new StringBuilder(s);
        if(x>y){
            score=removeAB(sb,score,x);
            score=removeBA(sb,score,y);
        }
        else{
            score=removeBA(sb,score,y);
            score=removeAB(sb,score,x);
        }
        return score;
    }
    public static int removeAB(StringBuilder sb, int score, int x){
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='a' && sb.charAt(i+1)=='b'){
                sb.delete(i,i+2);
                score+=x;
                if(i==0){
                    i=-1;
                }
                else{
                    i=i-2;
                }
            }
        }
        return score;
    }

    public static int removeBA(StringBuilder sb, int score, int y){
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='b' && sb.charAt(i+1)=='a'){
                sb.delete(i,i+2);
                score+=y;
                if(i==0){
                    i=-1;
                }
                else{
                    i=i-2;
                }
            }
        }
        return score;
    }
}
