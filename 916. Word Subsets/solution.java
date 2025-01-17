class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list=new ArrayList<>();
        int[] bMax=new int[26];
        for(int i=0;i<words2.length;i++){
            int[] bCount=count(words2[i]);
            for(int j=0;j<26;j++){
                bMax[j]=Math.max(bMax[j],bCount[j]);
            }
        }

        for(int i=0;i<words1.length;i++){
            int[] aCount=count(words1[i]);
            boolean isSubset=true;
            for(int j=0;j<26;j++){
                if(aCount[j]<bMax[j]){
                    isSubset=false;
                }
            }
            if(isSubset){
                list.add(words1[i]);
            }
        }
        return list;
    }
    public int[] count(String s){
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        return count;
    }
}
