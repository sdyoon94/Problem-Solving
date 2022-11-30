#include <bits/stdc++.h>

using namespace std;

int main(){
    int X, i;
    scanf("%d", &X);
    for(i=1; (i*(i+1))/2<X; i++){}
    X=X-(i*(i-1))/2;
    if(i%2==0) printf("%d/%d\n", X, i-X+1);
    else printf("%d/%d\n",i-X+1, X);
    return 0;
}
