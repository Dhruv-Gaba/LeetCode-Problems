class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]){
            return image;
        }
        int orignal=image[sr][sc];
        colorImage(image,sr,sc,color,orignal);
        return image;
    }
    public void colorImage(int[][] image,int i, int j, int color,int orignal){
        image[i][j]=color;
        if(isValid(i,j+1,image) && image[i][j+1]==orignal){
            colorImage(image,i,j+1,color,orignal);
        }
        if(isValid(i,j-1,image) && image[i][j-1]==orignal){
            colorImage(image,i,j-1,color,orignal);
        }
        if(isValid(i+1,j,image) && image[i+1][j]==orignal){
            colorImage(image,i+1,j,color,orignal);
        }
        if(isValid(i-1,j,image) && image[i-1][j]==orignal){
            colorImage(image,i-1,j,color,orignal);
        }
    }
    public boolean isValid(int i,int j,int[][] image){
        return i>=0 && j>=0 && i<image.length && j<image[0].length;
    }
}
