#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T; cin >> T;
    while(T--){
        int N, M, order=1, max=0; cin >> N >> M;
        queue<pair<int, int>> q;
        vector<int> v;
        for(int i=0; i<N; i++){
            int tmp; cin >> tmp;
            q.push(make_pair(i, tmp));
            v.push_back(tmp);
        }
        sort(v.begin(), v.end());
        while(!q.empty()){
            if(q.front().second==v.back()){
                if(q.front().first==M){
                    cout << order << '\n';
                    break;
                }
                q.pop();
                v.pop_back();
                order++;
            }
            else{
                q.push(q.front());
                q.pop();
            }
        }
    }

    return 0;
}
