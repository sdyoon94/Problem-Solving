#include <bits/stdc++.h>

using namespace std;

int Facto(int i){
    if(i<=1) return 1;
    else return i*Facto(i-1);
}

int main(){
    int N;
    scanf("%d", &N);
    printf("%d\n", Facto(N));
    return 0;
}
