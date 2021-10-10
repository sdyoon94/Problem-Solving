#include <bits/stdc++.h>

using namespace std;

int main(){
    int n; cin >> n;
    int num=1;
    vector<int> stk, input;
    vector<char> ans;
    for(int i=0;i<n;i++){
        int tmp; cin >> tmp;
        input.push_back(tmp);
    }
    for(auto i : input){
        while(stk.empty()||stk.back()<i){
            stk.push_back(num);
            ans.push_back('+');
            num++;
        }
        if(stk.back()==i){
            stk.pop_back();
            ans.push_back('-');
        }
        else if(stk.back()>i){
            cout << "NO\n";
            return 0;
        }

    }
    for(auto i : ans) cout << i << "\n";
    return 0;
}
