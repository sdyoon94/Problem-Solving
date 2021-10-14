#include <bits/stdc++.h>
#define ll long long

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ll N; cin >> N;
    vector<ll> A(N);
    for(ll i=0; i<N; i++) cin >> A[i];
    ll B, C; cin >> B >> C;
    ll ans=0;
    for(ll i=0; i<N; i++){
        ans++;
        A[i]-=B;
        if(A[i]>0){
            ans+=(A[i]-1)/C;
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}
