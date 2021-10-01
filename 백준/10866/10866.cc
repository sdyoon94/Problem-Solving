#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    deque<int> dq;
    int N; cin >> N;
    while(N--){
        string tmp; cin >> tmp;
        if(tmp.compare("push_front")==0){
            int x; cin >> x;
            dq.push_front(x);
        }
        else if(tmp.compare("push_back")==0){
            int x; cin >> x;
            dq.push_back(x);
        }
        else if(tmp.compare("pop_front")==0){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.front() << '\n';
                dq.pop_front();
            }
        }
        else if(tmp.compare("pop_back")==0){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.back() << '\n';
                dq.pop_back();
            }
        }
        else if(tmp.compare("size")==0){
            cout << dq.size() << '\n';
        }
        else if(tmp.compare("empty")==0){
            cout << dq.empty() << '\n';
        }
        else if(tmp.compare("front")==0){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.front() << '\n';
            }
        }
        else if(tmp.compare("back")==0){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.back() << '\n';
            }
        }
    }
    return 0;
}