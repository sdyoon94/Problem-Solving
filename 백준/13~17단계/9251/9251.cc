#include <bits/stdc++.h>
#define MAX 1007

using namespace std;

char A[MAX], B[MAX];
int dp[MAX][MAX];

int main(){
    scanf("%s\n%s", A, B);
    int Alen=strlen(A), Blen=strlen(B);
    for(int i=1; i<=Alen; i++){
        for(int j=1; j<=Blen; j++){
            if(A[i-1]==B[j-1]) dp[i][j]=dp[i-1][j-1]+1;
            else dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
        }
    }
    printf("%d\n", dp[Alen][Blen]);
    return 0;
}
