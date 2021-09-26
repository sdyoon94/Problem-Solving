#include <bits/stdc++.h>

using namespace std;

int main(){
    bool chk[1000007];
    memset(chk, true, sizeof(chk));
    chk[0]=chk[1]=false;
    for(int i=2;i<1000007;i++){
        if(chk[i]){
            for(int j=2;i*j<1000007;j++){
                chk[i*j]=false;
            }
        }
    }
    int M, N;
    scanf("%d %d", &M, &N);
    for(int i=M; i<=N; i++){
        if(chk[i]){
            printf("%d\n", i);
        }
    }

    return 0;
}
