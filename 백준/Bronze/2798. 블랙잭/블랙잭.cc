#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, M, ans = 0;
    int *cards;
    scanf("%d %d", &N, &M);
    cards = new int[N];
    for(int i=0; i<N; i++){
        scanf("%d", cards+i);
    }
    for(int i=0; i<N-2; i++){
        for(int j=i+1; j<N-1; j++){
            for(int k=j+1; k<N; k++){
                int sum = cards[i] + cards[j] + cards[k];
                if(ans<sum && sum<=M){
                    ans=sum;
                }
            }
        }
    }
    printf("%d\n", ans);
    return 0;
}
