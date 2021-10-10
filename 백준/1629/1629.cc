#include <bits/stdc++.h>

using namespace std;

long long A, B, C, ans;

void input(){
    cin >> A >> B >> C;
}

void print(){
    cout << ans << '\n';
}

long long func(long long x, long long y){
    if(y==0) return 1;
    if(y==1) return x%C;
    long long tmp = func(x , y/2)%C;
    if(y%2) return tmp*tmp%C*x%C;
    return tmp*tmp%C;
}

void run(){
    input();
    ans=func(A, B);
    print();
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
