class Solution {
    public boolean canChange(String s, String t) {
        char[] start=s.toCharArray();
        char[] target=t.toCharArray();
        for(int i=0;i<target.length;i++){
            if(target[i]==start[i]){
                continue;
            }
            else if(i+1==start.length){
                return false;
            }
            else if(start[i]=='L'){
                return false;
            }
            else if(target[i]=='R'){
                return false;
            }
            else if(start[i]!='_' && target[i]!='_'){
                return false;
            }
            else{
                if(start[i]=='R'){
                    for(int j=i+1;j<target.length;j++){
                        if(start[j]=='_'){
                            start[j]='R';
                            start[i]='_';
                            break;
                        }
                        else if(start[j]=='L'){
                            return false;
                        }
                    }
                    if(start[i]=='R'){
                        return false;
                    }
                }
                else if(target[i]=='L'){
                    for(int j=i+1;j<start.length;j++){
                        if(start[j]=='R'){
                            return false;
                        }
                        else if(start[j]=='L'){
                            start[i]='L';
                            start[j]='_';
                            break;
                        }
                    }
                    if(start[i]=='_'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
