#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K; cin >> N >> K;
    queue<int> q;
    for(int i=1; i<=N; i++) q.push(i);
    cout << '<';
    while(q.size()!=1){
        for(int i=1; i<K; i++){
            q.push(q.front());
            q.pop();
        }
        cout << q.front() << ", ";
        q.pop();
    }
    cout << q.front() << ">\n";
    return 0;
}
