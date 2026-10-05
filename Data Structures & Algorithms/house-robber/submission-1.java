class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length+1];
        return gen(0,nums,dp);
    }

    public int gen(int i, int nums[], Integer dp[]){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int take = nums[i]+gen(i+2, nums,dp);
        int skip = gen(i+1, nums,dp);

        return dp[i]=Math.max(skip, take);
    }
}
