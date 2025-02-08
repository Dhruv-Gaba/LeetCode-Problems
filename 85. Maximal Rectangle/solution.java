class Solution {
    public int maximalRectangle(char[][] matrix) {
        int heights[][]=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            for(int i=0;i<matrix.length;i++){
                if(i==0){
                    heights[i][j]=matrix[i][j]=='0'?0:1;
                }else{
                    heights[i][j]=matrix[i][j]=='0'?0:heights[i-1][j]+1;
                }
            }
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,maxAreaHistogram(heights[i]));
        }
        return max;
    }
    public int maxAreaHistogram(int[] height){
        Stack<Integer> s=new Stack<>();
        int n=height.length;
        int nsl[]=new int[n];
        int nsr[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            int width=nsr[i]-nsl[i]-1;
            int area=height[i]*width;
            max=Math.max(max,area);
        }
        return max;
    }
}
