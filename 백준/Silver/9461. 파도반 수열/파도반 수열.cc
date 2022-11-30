#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    long long dp[101];
    dp[0]=0; dp[1]=1; dp[2]=1; dp[3]=1; dp[4]=2;
    for(int i=5;i<=100;i++){
        dp[i]=dp[i-1]+dp[i-5];
    }
    scanf("%d", &T);
    while(T--){
        int N;
        scanf("%d", &N);
        printf("%lld\n", dp[N]);
    }
    return 0;
}
