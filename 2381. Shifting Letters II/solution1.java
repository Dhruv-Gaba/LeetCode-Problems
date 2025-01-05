class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int diff[]=new int[n];
        for(int[] shift:shifts){
            if(shift[2]==1){
                diff[shift[0]]++;
                if(shift[1]+1<n){
                    diff[shift[1]+1]--;
                }
            }
            else{
                diff[shift[0]]--;
                if(shift[1]+1<n){
                    diff[shift[1]+1]++;
                }
            }
        }

        int noOfShifts=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            noOfShifts=(noOfShifts+diff[i])%26;

            if(noOfShifts<0)noOfShifts+=26;
            
            char shiftedChar=(char)('a'+(((s.charAt(i)-'a')+noOfShifts)%26));

            sb.append(shiftedChar);
        }
        return sb.toString();
    }
}
