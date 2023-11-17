public class CountOfSubsetSum {
    public int countSubSetSum(int[] nums, int S) {

        int[][] dp =new int[nums.length+1][S+1];

        for(int i=0;i<nums.length+1;i++)
            dp[i][0]=1;
        for(int j=1;j<S+1;j++)
            dp[0][j]=0;

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<S+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=  dp[i-1][j];
                }
            }
        }
        return  dp[nums.length][S];
    }
}
