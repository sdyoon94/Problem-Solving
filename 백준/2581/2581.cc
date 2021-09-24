#include <bits/stdc++.h>

using namespace std;

int main(){
    bool chk[10007];
    memset(chk, true, sizeof(chk));
    chk[0]=chk[1]=false;
    for(int i=2;i<10007;i++){
        if(chk[i]){
            for(int j=2;i*j<10007;j++){
                chk[i*j]=false;
            }
        }
    }
    int M, N, sum=0, min=10001;
    scanf("%d %d", &M, &N);
    for(int i=M;i<=N;i++){
        if(chk[i]){
            sum+=i;
            if(min>i) min=i;
        }
    }
    if(sum==0) printf("-1\n");
    else printf("%d\n%d\n", sum, min);
    return 0;
}
