#include <bits/stdc++.h>
#define MAX 500

using namespace std;

int n, tri[MAX][MAX], dp[MAX][MAX];

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            scanf("%d", &tri[i][j]);
        }
    }
    dp[0][0]=tri[0][0];
    for(int i=1; i<n; i++){
        for(int j=0; j<=i; j++){
            if(j==0) dp[i][j] = dp[i-1][j]+tri[i][j];
            else if(j==i) dp[i][j] = dp[i-1][j-1]+tri[i][j];
            else dp[i][j] = dp[i-1][j] > dp[i-1][j-1] ? dp[i-1][j]+tri[i][j] : dp[i-1][j-1]+tri[i][j];
        }
    }
    int max=0;
    for(int i=0; i<n; i++){
        if(dp[n-1][i]>max) max=dp[n-1][i];
    }
    printf("%d\n", max);
    return 0;
}
