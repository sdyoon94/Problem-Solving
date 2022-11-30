#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    scanf("%d", &T);
    while(T--){
        int x, y;
        scanf("%d %d", &x, &y);
        int dis=y-x;
        int N=sqrt(dis);
        if(dis-N*N==0){
            printf("%d\n", 2*N-1);
            continue;
        }
        else if(dis-N*N<=N){
            printf("%d\n", 2*N);
            continue;
        }
        else{
            printf("%d\n", 2*N+1);
            continue;
        }
    }
    return 0;
}
