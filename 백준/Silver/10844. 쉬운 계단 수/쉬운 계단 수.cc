#include <bits/stdc++.h>
#define MAX 100
using namespace std;

int N, dp[MAX][10];

int main(){
    scanf("%d", &N);
    for(int i=1; i<10; i++) dp[0][i]=1;
    for(int i=1; i<N; i++){
        for(int j=0; j<10; j++){
            if(j==0) dp[i][0]=dp[i-1][1];
            else if(j==9) dp[i][9]=dp[i-1][8];
            else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
        }
    }
    int sum=0;
    for(int i=0; i<10; i++){
        sum=(sum+dp[N-1][i])%1000000000;
    }
    printf("%d\n", sum);
    return 0;
}
