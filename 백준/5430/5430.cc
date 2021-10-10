#include <bits/stdc++.h>

using namespace std;

void input(string &cmd, int &n, deque<int> &dq){
    cin >> cmd;
    cin >> n;
    string tmp; cin >> tmp;
    bool chk = false;
    int num;
    for(auto C : tmp){
        if('0'<=C && C<='9'){
            if(chk){
                num*=10;
                num+=C-'0';
            }
            else{
                chk=true;
                num=C-'0';
            }
        }
        else if(chk){
            dq.push_back(num);
            chk=false;
        }
    }
}

void print(deque<int> &dq, bool R){
    cout << '[';
    while(dq.size()>1){
        if(R){
            cout << dq.back() << ',';
            dq.pop_back();
        }
        else{
            cout << dq.front() << ',';
            dq.pop_front();
        }
    }
    if(!dq.empty()) cout << dq.front() << "]\n";
    else cout << "]\n";
    return;
}

void run(){
    string cmd;
    int n;
    deque<int> dq;
    input(cmd, n, dq);
    bool R=false;
    for(auto i : cmd){
        if(i=='R'){
            R=!R;
            continue;
        }
        if(dq.empty()){
            cout << "error\n";
            return;
        }
        if(R) dq.pop_back();
        else dq.pop_front();
    }
    print(dq, R);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T; cin >> T;
    while(T--){
        run();
    }
    return 0;
}
