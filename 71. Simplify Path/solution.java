class Solution {
    public String simplifyPath(String path) {
        String[] pathArray=path.split("/");
        Stack<String> s=new Stack<>();
        for(String x:pathArray){
            if(x.equals("") || x.equals(".")){
                continue;
            }
            if(x.equals("..")){
                if(!s.isEmpty())s.pop();
                continue;
            }
            s.push(x);
        }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            String part=s.pop();
            sb.insert(0,part);
            sb.insert(0,"/");
        }
        return sb.length()==0?"/":sb.toString();
    }
}
