#include <bits/stdc++.h>
#define ll long long
#define P 1000000000000000

using namespace std;

void mult(pair<ll, ll> &A, int B){
    A.first*=B;
    A.second*=B;
    A.first+=A.second/P;
    A.second%=P;
}
void devide(pair<ll, ll> &A, int B){
    A.second+=(A.first%B)*P;
    A.first/=B;
    A.second/=B;
    A.first+=A.second/P;
    A.second%=P;
}
void print(pair<ll, ll> A){
    if(A.first==0) cout << A.second << '\n';
    else{
        cout << A.first;
        cout.width(15);
        cout.fill('0');
        cout << A.second << '\n';
    }
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    pair<ll, ll> ans;
    int n, m; cin >> n >> m;
    if(m>n/2) m=n-m;
    ans={0, 1};
    for(int i=1; i<=m; i++){
        mult(ans, n+1-i);
        devide(ans, i);
    }
    print(ans);
    return 0;
}