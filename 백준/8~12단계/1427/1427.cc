#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, num[10]={0};
    scanf("%d", &N);
    while(N){
        num[N%10]++;
        N/=10;
    }
    for(int i=9; i>=0; i--){
        for(int j=1; j<=num[i]; j++){
            printf("%d", i);
        }
    }
    return 0;
}
