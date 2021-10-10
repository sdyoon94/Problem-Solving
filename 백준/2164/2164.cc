#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    queue<int> q;
    for(int i=1; i<=N; i++) q.push(i);
    while(q.size()!=1){
        q.pop();
        q.push(q.front());
        q.pop();
    }
    cout << q.front() << '\n';
    return 0;
}
