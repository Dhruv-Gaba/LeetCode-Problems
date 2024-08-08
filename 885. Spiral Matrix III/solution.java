class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans=new int[rows*cols][2];
        int i=rStart;
        int j=cStart;
        int count=0;
        ans[0][0]=i;
        ans[0][1]=j;
        int idx=1;
        int temp;
        while(idx<rows*cols){
            count++;
            //right
            temp=count;
            while(temp>0){
                j++;
                if(i<rows && i>=0 && j<cols && j>=0){
                    ans[idx][0]=i;
                    ans[idx++][1]=j;
                }
                temp--;
            }
            
            //down
            temp=count;
            while(temp>0){
                i++;
                if(i<rows && i>=0 && j<cols && j>=0){
                    ans[idx][0]=i;
                    ans[idx++][1]=j;
                }
                temp--;
            }
            //left
            count++;
            temp=count;
            while(temp>0){
                j--;
                if(i<rows && i>=0 && j<cols && j>=0){
                    ans[idx][0]=i;
                    ans[idx++][1]=j;
                }
                temp--;
            }
            //up
            temp=count;
            while(temp>0){
                i--;
                if(i<rows && i>=0 && j<cols && j>=0){
                    ans[idx][0]=i;
                    ans[idx++][1]=j;
                }
                temp--;
            }
        }
        return ans;
    }
}
