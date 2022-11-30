#include <bits/stdc++.h>

using namespace std;
int GCD(int a, int b){
    if(a>b){
        int tmp = b;
        b=a;
        a=tmp;
    }
    if(a==0) return b;
    else return GCD(b%a, a);
}
int main(){
    int N; scanf("%d", &N);
    while(N--){
        int a, b;
        scanf("%d %d", &a, &b);
        int gcd=GCD(a, b);
        printf("%d\n", a*b/gcd);
    }
    return 0;
}
