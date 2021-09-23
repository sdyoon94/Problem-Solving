#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, min = 1000001, max = -1000001;
    scanf("%d", &N);
    while(N--){
        int tmp;
        scanf("%d", &tmp);
        if(tmp<min) min = tmp;
        if(tmp>max) max = tmp;
    }
    printf("%d %d\n", min, max);
    
    return 0;
}
