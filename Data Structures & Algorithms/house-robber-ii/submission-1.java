class Solution {
    public int rob(int[] nums) {
        Integer dp[][] = new Integer[nums.length+1][2];
        return gen(0,nums,false,dp);
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
