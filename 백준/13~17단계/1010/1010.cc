#include <bits/stdc++.h>
#define MAX 31

using namespace std;

int main(){
    int pas[MAX][MAX];
    memset(pas, 0, sizeof(int) * MAX * MAX);
    for(int i=0; i<MAX; i++) pas[i][0]=1;
    for(int i=1; i<MAX; i++){
        for(int j=1; j<=i; j++){
            pas[i][j]=pas[i-1][j-1]+pas[i-1][j];
        }
    }
    int T; scanf("%d", &T);
    while(T--){
        int N, K; scanf("%d %d", &N, &K);
        printf("%d\n", pas[K][N]);
    }
    return 0;
}