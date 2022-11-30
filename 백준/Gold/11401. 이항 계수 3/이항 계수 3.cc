#include <bits/stdc++.h>
#define ll long long
#define P 1000000007

using namespace std;

int N, K;

ll facto(ll A){
    ll ans=1;
    for(int i=2; i<=A; i++) ans=ans*i%P;
    return ans;
}

ll po(ll A, ll B){
    if(B==1) return A%P;
    ll tmp = po(A, B/2)%P;
    if(B%2) return tmp%P*tmp%P*A%P;
    else return tmp%P*tmp%P;
}

void input(){
    cin >> N >> K;
    return;
}

void run(){
    input();
    ll answer = facto(N)%P * po(facto(K), P-2)%P * po(facto(N-K), P-2)%P;
    cout << answer << '\n';
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
