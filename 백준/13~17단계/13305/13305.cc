#include <bits/stdc++.h>

using namespace std;

int main(){
    long long N;
    scanf("%lld", &N);
    long long *dis = new long long[N-1], *price = new long long[N];
    for(long long i=0; i<N-1; i++) scanf("%lld", &dis[i]);
    for(long long i=0; i<N; i++) scanf("%lld", &price[i]);
    long long ans=0, cur_price=price[0];
    for(long long i=1; i<N; i++){
        ans+=dis[i-1]*cur_price;
        if(cur_price>price[i]){
            cur_price=price[i];
        }
    }
    printf("%lld\n", ans);

    return 0;
}
