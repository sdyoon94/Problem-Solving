#include <bits/stdc++.h>

using namespace std;

bool is_hansu(int num){
    int a[3];
    for(int i=0; i<3; i++){
        a[i]=num%10;
        num/=10;
    }
    if(a[1]*2==a[0]+a[2]) return true;
    else return false;
}

int main(){
    bool chk[1001]={false};
    for(int i=1;i<100;i++) chk[i]=true;
    for(int i=100;i<1000;i++) chk[i]=is_hansu(i);

    int N, num=0;
    scanf("%d", &N);
    for(int i=1; i<=N; i++) if(chk[i]) num++;
    printf("%d\n", num);
    return 0;
}
