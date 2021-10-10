#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int main(){
    vector<int> X;
    vector<int> sort_X;
    unordered_map<int, int> rank;
    unordered_map<int, bool> chk;
    int N, i=0;
    scanf("%d", &N);
    while(N--){
        int tmp;
        scanf("%d", &tmp);
        X.push_back(tmp);
        if(!chk[tmp]){
            sort_X.push_back(tmp);
            chk[tmp]=true;
        }
        rank[tmp]=0;
    }
    sort(sort_X.begin(), sort_X.end());
    for(auto x : sort_X){
        rank[x]=i++;
    }
    for(auto V : X){
        printf("%d ", rank[V]);
    }
    return 0;
}