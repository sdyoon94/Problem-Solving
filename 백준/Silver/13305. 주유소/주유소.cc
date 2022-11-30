#include <bits/stdc++.h>

using namespace std;

int main(){
    int N;
    scanf("%d", &N);
    int *dis = new int[N-1], *price = new int[N];
    for(int i=0; i<N-1; i++) scanf("%d", &dis[i]);
    for(int i=0; i<N; i++) scanf("%d", &price[i]);
    int ans=0, cur_price=price[0];
    for(int i=1; i<N; i++){
        ans+=dis[i-1]*cur_price;
        if(cur_price>price[i]){
            cur_price=price[i];
        }
    }
    printf("%d\n", ans);

    return 0;
}
