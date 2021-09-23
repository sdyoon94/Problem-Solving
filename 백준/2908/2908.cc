#include <bits/stdc++.h>

using namespace std;

int main(){
    int a, b, c, d;
    scanf("%d %d", &a, &b);
    c = (a%10) * 100;
    a/=10;
    c+= (a%10) * 10;
    a/=10;
    c+= (a%10);
    d = (b%10) * 100;
    b/=10;
    d+= (b%10) * 10;
    b/=10;
    d+= (b%10);

    if(c>d) printf("%d\n", c);
    else printf("%d\n", d);
    
    return 0;
}
