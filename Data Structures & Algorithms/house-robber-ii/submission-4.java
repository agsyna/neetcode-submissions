class Solution {
    //first - is true - 0
    //first not taken - 1
    public int rob(int[] nums) {
        int dp[][] = new int[nums.length][2];
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        dp[0][0]=nums[0];
        dp[1][0]=Math.max(nums[0], nums[1]);
        dp[1][1]=nums[1];

        for(int i=2;i<n;i++){
            int j=0;
            if(i==n-1){
                j=1;
            }
            for(;j<2;j++){
                dp[i][j]=Math.max(nums[i]+dp[i-2][j], dp[i-1][j]);
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++){
        //         System.out.print(dp[i][j]+" , ");
        //     }
        //     System.out.println();
        // }

        return Math.max(dp[n-2][0], dp[n-1][1]);
    }

    public int gen(int i, int nums[], boolean first, Integer dp[][]){
        if(i>=nums.length){
            return 0;
        }
        if(first && i==nums.length-1){
            return 0;
        }
        int val = first?0:1;
        if(dp[i][val]!=null){
            return dp[i][val];
        }
        int take=0;
        if(i==0){
            take = gen(i+2,nums, true,dp)+nums[i];
        }else{
            take = gen(i+2, nums, first,dp)+nums[i];
        }
        int skip = gen(i+1,nums, first,dp);

        return dp[i][val]=Math.max(take, skip);
    }
}
