class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int currDirection=0;
        int i=0,j=0;
        boolean obs=false;
        int max=0;
        for(int x:commands){
            obs=false;
            if(x==-1){
                currDirection=currDirection<3?currDirection+1:0;
            }
            else if(x==-2){
                currDirection=currDirection>0?currDirection-1:3;
            }
            else{
                if(currDirection==0){
                    for(int ob[]:obstacles){
                        if(ob[0]==i && ob[1]>j && ob[1]<=j+x){
                            j=ob[1]-1;
                            obs=true;
                            break;
                        }
                    }
                    if(!obs)j+=x;
                    max=Math.max(max,(int)(Math.pow(i,2)+Math.pow(j,2)));
                }
                else if(currDirection==1){
                    for(int ob[]:obstacles){
                        if(ob[1]==j && ob[0]>i && ob[0]<=i+x){
                            i=ob[0]-1;
                            obs=true;
                            break;
                        }
                    }
                    if(!obs)i+=x;
                    max=Math.max(max,(int)(Math.pow(i,2)+Math.pow(j,2)));
                }
                else if(currDirection==2){
                    for(int ob[]:obstacles){
                        if(ob[0]==i && ob[1]<j && ob[1]>=j-x){
                            j=ob[1]+1;
                            obs=true;
                            break;
                        }
                    }
                    if(!obs)j-=x;
                    max=Math.max(max,(int)(Math.pow(i,2)+Math.pow(j,2)));
                }
                else{
                    for(int ob[]:obstacles){
                        if(ob[1]==j && ob[0]<i && ob[0]>=i-x){
                            i=ob[0]+1;
                            obs=true;
                            break;
                        }
                    }
                    if(!obs)i-=x;
                    max=Math.max(max,(int)(Math.pow(i,2)+Math.pow(j,2)));
                }
            }
        }
        return max;
    }
}
