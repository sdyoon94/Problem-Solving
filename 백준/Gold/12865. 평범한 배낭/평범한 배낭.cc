#include <bits/stdc++.h>

using namespace std;

void run(int N, int K){
    int *weight = new int[N+1], *value = new int[N+1], **dp = new int *[N+1];
    for(int i=1; i<=N; i++) scanf("%d %d", &weight[i], &value[i]);
    for(int i=0; i<=N; i++) dp[i] = new int[K+1];
    for(int i=1; i<=N; i++){
        for(int j=1; j<=K; j++){
            dp[i][j]=dp[i-1][j];
            if(j>=weight[i]){
                dp[i][j] = max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j]);
            }
        }
    }
    printf("%d\n", dp[N][K]);
}

int main(){
    int N, K;
    scanf("%d %d", &N, &K);
    run(N, K);
    return 0;
}