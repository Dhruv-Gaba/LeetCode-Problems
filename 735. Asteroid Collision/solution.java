class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        boolean[] isDestroyed=new boolean[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(asteroids[i]>0){
                while(!s.isEmpty() && Math.abs(asteroids[s.peek()])<asteroids[i]){
                    isDestroyed[s.pop()]=true;
                }
                if(!s.isEmpty()){
                    isDestroyed[i]=true;
                    if(Math.abs(asteroids[s.peek()])==asteroids[i]){
                        isDestroyed[s.pop()]=true;
                    }
                }
            }
            else{
                s.push(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!isDestroyed[i]){
                ans.add(asteroids[i]);
            }
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
