#include <bits/stdc++.h>

using namespace std;

int main(){
    int N;
    scanf("%d", &N);
    vector<int> time;
    for(int i=0; i<N; i++){
        int tmp;
        scanf("%d", &tmp);
        time.push_back(tmp);
    }
    sort(time.begin(), time.end());
    int ans=0, now=0;
    for(auto i : time){
        now+=i;
        ans+=now;
    }
    printf("%d", ans);
    return 0;
}
