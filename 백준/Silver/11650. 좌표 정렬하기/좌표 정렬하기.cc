#include <bits/stdc++.h>

using namespace std;

int main(){
    vector<pair<int, int>> xy;
    int N;
    scanf("%d", &N);
    while(N--){
        pair<int, int> tmp;
        scanf("%d %d", &tmp.first, &tmp.second);
        xy.push_back(tmp);
    }
    sort(xy.begin(), xy.end());
    for(auto i : xy) printf("%d %d\n", i.first, i.second);
    return 0;
}
