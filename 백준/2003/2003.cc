#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, ans = 0; cin >> N >> M;
    vector<int> v(N);
    for(int i=0; i<N; i++) cin >> v[i];
    for(int i=0; i<N; i++){
        int sum=0;
        for(int j=i; j<N; j++){
            sum+=v[j];
            if(sum==M){
                ans++;
                break;
            }
            else if(sum>M) break;
        }
    }
    cout << ans << '\n';
    return 0;
}
