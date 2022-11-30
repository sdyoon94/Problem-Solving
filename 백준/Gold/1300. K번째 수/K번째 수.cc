#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K; cin >> N >> K;
    int left=1, right=K, ans;
    while(left<=right){
        int mid = (left+right)/2;
        int cnt=0;
        for(int i=1; i<=N; i++){
            cnt += min(mid/i, N);
        }
        if(cnt<K) left=mid+1;
        else{
            right=mid-1;
            ans=mid;
        }
    }
    cout << ans << '\n';
    return 0;
}
