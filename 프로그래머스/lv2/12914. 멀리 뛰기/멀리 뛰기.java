class Solution {
    public long solution(int n) {
        int[] dp = new int[n+3];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++) {
            dp[i]= (dp[i-1]+dp[i-2])%1234567;
        }
        // 경우의 수 뭐시기. 뭔가 그전꺼에서 하나 더하는 느낌이 있다면 디피를 고려하라
        return dp[n];
    }
}