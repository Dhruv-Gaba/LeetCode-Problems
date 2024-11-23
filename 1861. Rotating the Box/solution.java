class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] result=new char[box[0].length][box.length];
        for(int i=0;i<box.length;i++){
            int count=0;
            for(int j=0;j<box[0].length;j++){
                if(box[i][j]=='#'){
                    count++;
                }
                else if(box[i][j]=='*'){
                    result[j][result[0].length-1-i]='*';
                    int k=j-1;
                    while(count>0){
                        result[k][result[0].length-1-i]='#';
                        count--;
                        k--;
                    }
                    continue;
                }
                result[j][result[0].length-1-i]='.';
            }
            int k=box[0].length-1;
            while(count>0){
                result[k][result[0].length-1-i]='#';
                count--;
                k--;
            }
        }
        return result;
    }
}
