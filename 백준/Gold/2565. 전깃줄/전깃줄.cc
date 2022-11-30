#include <bits/stdc++.h>

using namespace std;

bool cmp(pair<int, int> A, pair<int, int> B){
    return A.first < B.first;
}

int main(){
    int N;
    scanf("%d", &N);
    int *dp=new int[N];
    vector<pair<int, int>> wire;
    for(int i=0; i<N; i++){
        pair<int, int> tmp;
        scanf("%d %d", &tmp.first, &tmp.second);
        wire.push_back(tmp);
    }
    sort(wire.begin(), wire.end(), cmp);
    dp[0]=1;
    for(int i=1; i<N; i++){
        int cur=1;
        for(int j=0; j<i; j++){
            if(wire[j].second<wire[i].second) cur=max(cur, dp[j]+1);
        }
        dp[i]=cur;
    }
    int maxi=0;
    for(int i=0; i<N; i++) maxi=max(maxi, dp[i]);
    printf("%d\n", N-maxi);
    return 0;
}
