#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, num_3=0, num_5=0;
    scanf("%d", &N);
    while(N>=0){
        if(N%5==0){
            num_5=N/5;
            printf("%d\n", num_3 + num_5);
            return 0;
        }
        N-=3;
        num_3++;
    }
    printf("-1\n");
    return 0;
}
