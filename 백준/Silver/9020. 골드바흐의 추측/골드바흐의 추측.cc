#include <bits/stdc++.h>

using namespace std;

int main(){
    bool chk[10010];
    memset(chk, true, sizeof(chk));
    chk[0]=chk[1]=false;
    for(int i=2;i<10010;i++){
        if(chk[i]){
            for(int j=2;i*j<10010;j++){
                chk[i*j]=false;
            }
        }
    }
    int T, N;
    scanf("%d",&T);
    while(T--){
        int ans;
        scanf("%d", &N);
        for(int i=2; i<=N/2; i++){
            if(chk[i]&&chk[N-i]){
                ans=i;
            }
        }
        printf("%d %d\n", ans, N-ans);
    }

    return 0;
}
