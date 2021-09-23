#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, i=0, newN;
    scanf("%d", &N);
    newN=N;
    do{
        newN = (newN % 10) * 10 + ((newN / 10) + (newN % 10)) % 10;
        i++;
    }while(N!=newN);

    printf("%d\n",i);

    return 0;
}