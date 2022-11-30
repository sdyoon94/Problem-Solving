#include <bits/stdc++.h>

using namespace std;

void comb(int a, int b){
    if(b>a/2) b=a-b;
    int c=1, d=1;
    for(int i=1; i<=b; i++){
        c*=a+1-i;
        d*=i;
    }
    printf("%d\n", c/d);
}

int main(){
    int N, K; scanf("%d %d", &N, &K);
    comb(N, K);
    return 0;
}
