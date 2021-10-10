#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, X;
    scanf("%d %d", &N, &X);
    while(N--){
        int a;
        scanf("%d",&a);
        if(a<X) printf("%d ",a);
    }
    return 0;
}
