#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, K;
    scanf("%d %d", &N, &K);
    int *coin = new int[N];
    for(int i=0; i<N; i++){
        scanf("%d", &coin[i]);
    }
    int ans=0;
    while(K){
        for(int i=0; i<N; i++){
            if(coin[i]>K){
                ans+= K/coin[i-1];
                K%=coin[i-1];
                break;
            }
            else if(i==N-1){
                ans+= K/coin[i];
                K%=coin[i];
                break;
            }
        }
    }
    printf("%d\n", ans);
    return 0;
}
