#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b){
    if(a==0) return b;
    if(a > b) return gcd(a%b, b);
    else return gcd(b%a, a);
}

int main(){
    int N; scanf("%d", &N);
    int ring; scanf("%d", &ring);
    for(int i=1; i<N; i++){
        int tmp; scanf("%d", &tmp);
        int div=gcd(ring, tmp);
        printf("%d/%d\n", ring/div, tmp/div);
    }
    return 0;
}
