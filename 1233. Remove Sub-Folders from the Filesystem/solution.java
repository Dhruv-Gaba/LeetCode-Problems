class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        String prev=folder[0];
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            if(!(folder[i].startsWith(prev) && folder[i].charAt(prev.length())=='/')){
                prev=folder[i];
                ans.add(prev);
            }
        }
        return ans;
    }
}
