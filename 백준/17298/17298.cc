#include <bits/stdc++.h>

using namespace std;

int main(){
    int N; scanf("%d", &N);
    vector<pair<int, int>> input;
    int *ans = new int[N];
    for(int i=0; i<N; i++){
        int tmp; scanf("%d", &tmp);
        if(input.empty()||input.back().second>=tmp){
            input.push_back(make_pair(i,tmp));
            continue;
        }
        while(!input.empty()&&input.back().second<tmp){
            ans[input.back().first]=tmp;
            input.pop_back();
        }
        input.push_back(make_pair(i,tmp));
    }
    while(!input.empty()){
        ans[input.back().first]=-1;
        input.pop_back();
    }
    for(int i=0; i<N; i++) printf("%d ", ans[i]);
    printf("\n");
    return 0;
}
