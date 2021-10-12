#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    vector<int> A(N);
    for(int i=0; i<N; i++) cin >> A[i];
    int B, C; cin >> B >> C;
    int ans=0;
    for(int i=0; i<N; i++){
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
