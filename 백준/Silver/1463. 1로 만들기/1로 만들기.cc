#include <bits/stdc++.h>
#define MAX 1000001

using namespace std;

int N, dp[MAX];

int main(){
    scanf("%d", &N);
    dp[1]=0;
    for(int i=1;i<=N;i++){
        if(i*3<=N && (dp[i*3]==0 || dp[i*3]>dp[i]+1)) dp[i*3]=dp[i]+1;
        if(i*2<=N && (dp[i*2]==0 || dp[i*2]>dp[i]+1)) dp[i*2]=dp[i]+1;
        if(i+1<=N && (dp[i+1]==0 || dp[i+1]>dp[i]+1)) dp[i+1]=dp[i]+1;
    }
    printf("%d\n", dp[N]);
    return 0;
}
