#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    scanf("%d", &T);
    while(T--){
        int H, W, N, floor, nth;
        scanf("%d %d %d", &H, &W, &N);
        
        floor=N%H;
        nth=(N/H)+1;
        if(floor==0){
            floor=H;
            nth--;
        }
        if(nth<10) printf("%d0%d\n",floor,nth);
        else printf("%d%d\n",floor,nth);
        
    }
    return 0;
}
