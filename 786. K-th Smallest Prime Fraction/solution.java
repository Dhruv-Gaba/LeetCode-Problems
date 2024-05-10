class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left=0,right=1.0;
        int n=arr.length;
        while(left<right){
            int totalSmallerFractions=0;
            double maxFraction=0.0;
            double mid=(left+right)/2;
            int j=1;
            int num=0,den=0;
            for(int i=0;i<n;i++){
                while(j<n && arr[i]>=mid*arr[j]){
                    j++;
                }
                if(j==n){
                    break;
                }
                totalSmallerFractions+=n-j;
                double fraction=(float)arr[i]/arr[j];
                if(fraction>maxFraction){
                    maxFraction=fraction;
                    num=i;
                    den=j;
                }
            }
            if(totalSmallerFractions==k){
                return new int[]{arr[num],arr[den]};
            }
            else if(totalSmallerFractions>k){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        return new int[]{};
    }
}
