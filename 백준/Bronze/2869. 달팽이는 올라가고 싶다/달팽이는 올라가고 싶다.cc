#include <bits/stdc++.h>

using namespace std;

int main(){
    double A, B, C, n;
    scanf("%lf %lf %lf", &A, &B, &C);
    n=(C-B)/(A-B);
    if((int)n<(C-B)/(A-B)) n++;
    printf("%d\n", (int)n);
    return 0;
}
