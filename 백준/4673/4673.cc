#include <bits/stdc++.h>

using namespace std;

int d(int n){
    int ans=n;
    while(n){
        ans+=n%10;
        n/=10;
    }
    return ans;
}

int main(){
    bool chk[10007]={false};
    for(int i=1; i<10007; i++) chk[i]=true;
    for(int i=1; i<10001; i++){
        if(chk[i]){
            int n=d(i);
            while(n<10001){
                chk[n]=false;
                n=d(n);
            }
        }
    }
    for(int i=1; i<10001; i++){
        if(chk[i]) printf("%d\n", i);
    }
    return 0;
}
