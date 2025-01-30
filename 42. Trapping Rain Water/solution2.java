class Solution {
    public int trap(int[] height) {
        //Using STACK
        Stack<Integer> start=new Stack<>();
        Stack<Integer> end=new Stack<>();
        int n=height.length;
        end.push(height[n-1]);
        for(int i=n-2;i>0;i--){
            if(height[i]>=end.peek()){
                end.push(height[i]);
            }
        }
        start.push(height[0]);
        int waterLevel=0;
        for(int i=1;i<n;i++){
            if(height[i]>=start.peek()){
                start.push(height[i]);
            }
            if(height[i]!=start.peek() && height[i]!=end.peek()){
                waterLevel+=(Math.min(start.peek(),end.peek())-height[i]);
            }
            if(height[i]==end.peek()){
                end.pop();
            }
        }
        return waterLevel;
    }
}
