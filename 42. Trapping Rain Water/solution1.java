class Solution {
    public int trap(int[] height) {
        //Using Arrays
        int leftmax[]=new int[height.length];
        leftmax[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        int rightmax[]=new int[height.length];
        rightmax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        int waterlevel;
        int totallevel=0;
        for(int i=0;i<height.length;i++){
            waterlevel=(Math.min(leftmax[i],rightmax[i]));
            totallevel+=(waterlevel-height[i]);
        }
        return totallevel;
    }
}
