#include <bits/stdc++.h>

using namespace std;

int main(){
    int num[10001]={0};
    int tmp, N;
    scanf("%d", &N);
    while(N--){
        scanf("%d", &tmp);
        num[tmp]++;
    }
    for(int i=0; i<10001; i++){
        for(int j=1; j<=num[i]; j++){
            printf("%d\n", i);
        }
    }

    return 0;
}