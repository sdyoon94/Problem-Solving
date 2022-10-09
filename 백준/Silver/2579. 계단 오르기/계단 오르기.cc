#include <bits/stdc++.h>
#define MAX 300

using namespace std;

int n, point[MAX], dp[MAX][2];

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &point[i]);
    }
    dp[0][0]=point[0]; dp[0][1]=point[0]; dp[1][0]= point[0]+point[1]; dp[1][1]=point[1];
    for(int i=2; i<n; i++){
        dp[i][0]=dp[i-1][1]+point[i];
        dp[i][1]=dp[i-2][0] > dp[i-2][1] ? dp[i-2][0]+point[i] : dp[i-2][1]+point[i];
    }
    printf("%d\n", dp[n-1][0]>dp[n-1][1]?dp[n-1][0]:dp[n-1][1]);
    return 0;
}
