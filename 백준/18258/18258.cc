#include <bits/stdc++.h>

using namespace std;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    queue<int> q;
    int N; cin >> N;
    while(N--){
        char input[10]; cin >> input;
        if(strcmp(input, "push")==0){
            int tmp; cin >> tmp;
            q.push(tmp);
        }
        else if(strcmp(input, "pop")==0){
            if(q.empty()) cout << "-1\n";
            else {
                cout << q.front() << '\n';
                q.pop();
            }
        }
        else if(strcmp(input, "size")==0){
            cout << q.size() << '\n';
        }
        else if(strcmp(input, "empty")==0){
            cout << q.empty() << '\n';
        }
        else if(strcmp(input, "front")==0){
            if(q.empty()) cout << "-1\n";
            else cout << q.front() << '\n';
        }
        else if(strcmp(input, "back")==0){
            if(q.empty()) cout << "-1\n";
            else cout << q.back() << '\n';
        }
    }
    return 0;
}
