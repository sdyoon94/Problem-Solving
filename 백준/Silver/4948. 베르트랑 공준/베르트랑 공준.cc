#include <bits/stdc++.h>

using namespace std;

int main(){
    bool chk[246920];
    memset(chk, true, sizeof(chk));
    chk[0]=chk[1]=false;
    for(int i=2;i<246920;i++){
        if(chk[i]){
            for(int j=2;i*j<246920;j++){
                chk[i*j]=false;
            }
        }
    }
    int N;
    scanf("%d",&N);
    while(N!=0){
        int ans=0;
        for(int i=N+1;i<=2*N;i++){
            if(chk[i]) ans++;
        }
        printf("%d\n", ans);
        scanf("%d",&N);
    }

    return 0;
}
