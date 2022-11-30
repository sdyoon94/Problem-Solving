#include <bits/stdc++.h>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b){
    return a.first < b.first;
}

int main(){
    int N;
    scanf("%d", &N);
    vector<pair<int, string>> user;
    while(N--){
        pair<int, string> tmp;
        cin >> tmp.first >> tmp.second;
        user.push_back(tmp);
    }
    stable_sort(user.begin(), user.end(), compare);
    for(auto i : user) cout << i.first << ' ' << i.second << "\n";
    return 0;
}
