#include <bits/stdc++.h>

using namespace std;

int main(){
    int tmp, num=0;
    bool chk[42]={false};
    while(scanf("%d", &tmp)!=EOF){
        if(!chk[tmp%42]){
            num++;
            chk[tmp%42]=true;
        }
    }
    printf("%d\n", num);
    return 0;
}
