class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[n+1];
        for(int i=0;i<2;i++){
            arr[i]=1;
        }
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
