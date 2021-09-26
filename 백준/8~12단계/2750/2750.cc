#include <bits/stdc++.h>

using namespace std;

int main(){
    int *num, N;
    scanf("%d", &N);
    num = new int[N];
    for(int i=0; i<N; i++){
        scanf("%d", num+i);
    }
    sort(num, num+N);
    for(int i=0; i<N; i++){
        printf("%d\n", *(num+i));
    }
    return 0;
}
