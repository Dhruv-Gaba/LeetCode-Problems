class Solution {
    public boolean queryString(String s, int n) {
        Queue<String> q=new LinkedList<>();
        q.add("1");
        while(n>0){
            String num=q.remove();
            q.add(num+"0");
            q.add(num+"1");
            if(!s.contains(num)){
                return false;
            }
            n--;
        }
        return true;
    }
}
