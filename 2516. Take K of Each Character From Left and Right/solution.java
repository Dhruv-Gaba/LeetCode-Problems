class Solution {
    public int takeCharacters(String s, int k) {
        int[] count=new int[3];
        for(int x:s.toCharArray()){
            count[x-'a']++;
        }
        if(count[0]<k || count[1]<k || count[2]<k){
            return -1;
        }
        int min=s.length();
        int right=s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            count[s.charAt(i)-'a']--;
            if(count[0]<k || count[1]<k || count[2]<k){
                for(int j=right;j>=i;j--){
                    count[s.charAt(j)-'a']++;
                    if(count[0]>=k && count[1]>=k && count[2]>=k){
                        right=j-1;
                        break;
                    }
                }
            }
            min=Math.min(min,i+(s.length()-right-1));
        }
        return min;
    }
}
