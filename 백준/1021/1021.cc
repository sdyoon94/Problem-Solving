#include <bits/stdc++.h>

using namespace std;

void input(int &N, int &M, queue<int> &q, vector<int> &num){
    cin >> N >> M;
    for(int i=1; i<=N; i++) q.push(i);
    for(int i=0; i<M; i++){
        int tmp; cin >> tmp;
        num.push_back(tmp);
    }
}

void run(){
    int N, M, ans=0;
    queue<int> q;
    vector<int> num;
    input(N, M, q, num);
    for(auto i : num){
        int move=0;
        while(q.front()!=i){
            q.push(q.front());
            q.pop();
            move++;
        }
        move = min(move, (int)q.size()-move);
        ans+=move;
        q.pop();
    }
    cout << ans << '\n';
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();
    return 0;
}
