#include <bits/stdc++.h>

using namespace std;

int main(){
    int N;
    int dp[1000001];
    dp[0]=1; dp[1]=1;
    for(int i=2;i<=1000000;i++) dp[i]=(dp[i-1]+dp[i-2])%15746;
    scanf("%d", &N);
    printf("%d\n", dp[N]);
    return 0;
}