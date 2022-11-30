#include <bits/stdc++.h>

using namespace std;

int main(){
    int T; scanf("%d", &T);
    while(T--){
        map<string, int> m;
        int N; scanf("%d", &N);
        while(N--){
            string tmp1, tmp2;
            cin >> tmp1 >> tmp2;
            m[tmp2]++;
        }
        int ans=1;
        for(auto i: m){
            ans*=i.second+1;
        }
        printf("%d\n", ans-1);
    }
    return 0;
}
