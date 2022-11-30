#include <bits/stdc++.h>

using namespace std;

int bhh(int i){
    int sum = i;
    while(i){
        sum+=i%10;
        i/=10;
    }
    return sum;
}

int main(){
    int N;
    scanf("%d", &N);
    for(int i=1; i<N; i++){
        if(bhh(i)==N){
            printf("%d\n", i);
            return 0;
        }
    }
    printf("0\n");
    return 0;
}
