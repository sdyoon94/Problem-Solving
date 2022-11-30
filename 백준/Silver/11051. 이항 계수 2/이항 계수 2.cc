#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, K; scanf("%d %d", &N, &K);
    int pas[1001][1001];
    memset(pas, 0, sizeof(int) * 1001 * 1001);
    for(int i=0; i<=1000; i++) pas[i][0]=1;
    for(int i=1; i<=1000; i++){
        for(int j=1; j<=i; j++){
            pas[i][j]=pas[i-1][j-1]+pas[i-1][j];
            pas[i][j]%=10007;
        }
    }
    printf("%d\n", pas[N][K]);
    return 0;
}
