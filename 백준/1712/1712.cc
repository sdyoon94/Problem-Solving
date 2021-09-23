#include <bits/stdc++.h>

using namespace std;

int main(){
    double A, B, C, n;
    scanf("%lf %lf %lf", &A, &B, &C);
    if(C<=B){
        printf("-1\n");
        return 0;
    }
    n=A/(C-B);
    if((int)n<=A/(C-B)) n++;
    printf("%d\n",(int)n);
    return 0;
}
