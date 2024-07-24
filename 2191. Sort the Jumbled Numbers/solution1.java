class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer[]> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int mappedValue=0;
            int temp=nums[i];
            int place=1;
            if(temp==0){
                list.add(new Integer[] {mapping[0],i});
                continue;
            }
            while(temp>0){
                mappedValue=mappedValue+place*mapping[temp%10];
                place*=10;
                temp/=10;
            }
            list.add(new Integer[] {mappedValue,i});
        }

        Collections.sort(list, (a,b)->a[0]-b[0]);

        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[list.get(i)[1]];
        }
        return ans;
    }
}
