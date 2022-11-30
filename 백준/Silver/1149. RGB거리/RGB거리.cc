#include <bits/stdc++.h>
#define MAX 1000
using namespace std;

int N, price[MAX][3], dp[MAX][3];

int main(){
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        for(int j=0; j<3; j++){
            scanf("%d", &price[i][j]);
        }
    }
    for(int i=0; i<3; i++){
        dp[0][i]=price[0][i];
    }
    for(int i=1; i<N; i++){
        dp[i][0]= (dp[i-1][1]<dp[i-1][2]) ? dp[i-1][1]+price[i][0] : dp[i-1][2]+price[i][0];
        dp[i][1]= (dp[i-1][0]<dp[i-1][2]) ? dp[i-1][0]+price[i][1] : dp[i-1][2]+price[i][1];
        dp[i][2]= (dp[i-1][0]<dp[i-1][1]) ? dp[i-1][0]+price[i][2] : dp[i-1][1]+price[i][2];
    }
    int mini=INT_MAX;
    for(int i=0; i<3; i++){
        if(dp[N-1][i]<mini) mini=dp[N-1][i];
    }
    printf("%d\n", mini);
    return 0;
}