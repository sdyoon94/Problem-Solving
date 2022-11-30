#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    int *arr = new int[n], **dp = new int *[n];
    for(int i=0; i<n; i++){
        scanf("%d", &arr[i]);
        dp[i] = new int[2];
    }
    dp[0][0]=arr[0]; dp[0][1]=arr[0];
    for(int i=1; i<n; i++){
        dp[i][0]=max(dp[i-1][0], dp[i-1][1]);
        dp[i][1]=max(dp[i-1][1]+arr[i], arr[i]);
    }
    printf("%d\n", max(dp[n-1][0], dp[n-1][1]));
    return 0;
}
