class Solution {
    public String shortestPalindrome(String s) {
        int n=s.length();
        if(n==0){
            return s;
        }
        int left=0;
        for(int right=n-1;right>=0;right--){
            if(s.charAt(right)==s.charAt(left)){
                left++;
            }
        }
        if(left==n){
            return s;
        }

        String nonPalineromeSuffix=s.substring(left);
        StringBuilder reversedSuffix=new StringBuilder(nonPalineromeSuffix).reverse();

        return reversedSuffix.append(shortestPalindrome(s.substring(0,left))).append(nonPalineromeSuffix).toString();
    }
}


