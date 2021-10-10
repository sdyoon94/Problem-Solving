#include <bits/stdc++.h>

using namespace std;

int Fibo(int i){
    if(i<=1) return i;
    else return Fibo(i-2) + Fibo(i-1);
}

int main(){
    int n;
    scanf("%d", &n);
    printf("%d\n", Fibo(n));
    return 0;
}
