class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            s.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]<=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=nums[s.peek()];
            }
            s.push(i);
        }
        return ans;
    }
}

// 4 3 2 
