class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<heights.length;i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] ans=new String[names.length];
        for(int i=heights.length-1;i>=0;i--){
            ans[names.length-1-i]=map.get(heights[i]);
        }
        return ans;
    }
}
