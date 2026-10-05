class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length+1];
        if(nums.length==1){
            return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        // return gen(0,nums,dp);
        for(int i=2;i<nums.length;i++){
            // System.out.println("i = "+i);
            dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return Math.max(dp[nums.length-1], dp[nums.length-2]);
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
