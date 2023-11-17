public class EqualPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        if(n>0){
            for(int i=0;i<nums.length;i++){
                sum = sum+nums[i];
            }
        }
        boolean[][] dp =new boolean[n+1][sum/2+1];
        if(sum%2>0){
            return false;
        }else{
            for(int i=0;i<=n;i++){
                dp[i][0]=true;
            }
            for(int j=1;j<=sum/2;j++){
                dp[0][j]=false;
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=sum/2;j++){
                    if(nums[i-1]<=j){
                        dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][sum/2];
    }
}
