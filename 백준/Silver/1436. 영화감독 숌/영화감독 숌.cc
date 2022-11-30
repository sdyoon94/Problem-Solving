#include <bits/stdc++.h>

using namespace std;

bool is_JM(int n){
    int num_6=0;
    bool chk=false;
    while(n){
        if(n%10==6) num_6++;
        else num_6=0;
        n/=10;
        if(num_6==3) return true;
    }
    return false;
}

int main(){
    int N, ans=0;
    scanf("%d", &N);
    while(N){
        ans++;
        if(is_JM(ans)) N--;
    }
    printf("%d\n", ans);
    return 0;
}