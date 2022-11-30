#include <bits/stdc++.h>

using namespace std;

int main(){
    bool chk[1007];
    memset(chk, true, sizeof(chk));
    chk[0]=chk[1]=false;
    for(int i=2;i<1007;i++){
        if(chk[i]){
            for(int j=2;i*j<1007;j++){
                chk[i*j]=false;
            }
        }
    }
    int N, tmp, ans=0;
    scanf("%d", &N);
    while(N--){
        scanf("%d", &tmp);
        if(chk[tmp]) ans++;
    }
    printf("%d\n", ans);

    return 0;
}
