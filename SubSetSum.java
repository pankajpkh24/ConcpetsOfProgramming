public class SubSetSum {
    public int solve(int[] A, int B) {
        boolean[][] dp =new boolean[A.length+1][B+1];

        for(int i=0;i<=A.length;i++)
            dp[i][0]=true;
        for(int j=1;j<=B;j++)
            dp[0][j]=false;

        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B;j++){
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j-A[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=  dp[i-1][j];
                }
            }
        }

        if(dp[A.length][B]){
            return 1;
        }
        return  0;
    }
}
