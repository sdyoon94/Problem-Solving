#include <bits/stdc++.h>

using namespace std;

int main(){
    int N,sum=0;
    char str[107];
    scanf("%d", &N);
    scanf("%s",str);
    for(int i=0; i<N; i++) sum+=str[i]-'0';
    printf("%d\n", sum);
    return 0;
}
