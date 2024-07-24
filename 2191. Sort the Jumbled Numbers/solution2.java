class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer[]> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String str=Integer.toString(nums[i]);
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<str.length();j++){
                sb.append(mapping[str.charAt(j)-'0']);
            }
            int mappedValue=Integer.parseInt(sb.toString());
            list.add(new Integer[] {mappedValue,i});
        }

        Collections.sort(list, new Comparator<Integer[]>(){
            public int compare(Integer[] a1, Integer a2[]){
                return a1[0].compareTo(a2[0]);
            }
        });

        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[list.get(i)[1]];
        }
        return ans;
    }
}
