#include <bits/stdc++.h>

using namespace std;

int main(){
    vector<int> stk;
    int K; cin >> K;
    while(K--){
        int tmp; cin >> tmp;
        if(tmp==0) stk.pop_back();
        else stk.push_back(tmp);
    }
    int sum=0;
    for(auto i : stk) sum+=i;
    cout << sum << "\n";
    return 0;
}
