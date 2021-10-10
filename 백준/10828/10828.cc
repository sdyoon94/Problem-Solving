#include <bits/stdc++.h>

using namespace std;

int main(){
    int N; scanf("%d", &N);
    vector<int> stk;
    while(N--){
        char cmd[10]; scanf("%s", cmd);
        int size = strlen(cmd);
        if(!strcmp(cmd, "push")){
            int tmp; scanf("%d", &tmp);
            stk.push_back(tmp);
        }
        else if(!strcmp(cmd, "pop")){
            if(stk.empty()) printf("-1\n");
            else printf("%d\n", stk.back()), stk.pop_back();
        }
        else if(!strcmp(cmd, "size")) printf("%lu\n", stk.size());
        else if(!strcmp(cmd, "empty")) printf("%d\n", stk.empty());
        else if(!strcmp(cmd, "top")){
            if(stk.empty()) printf("-1\n");
            else printf("%d\n", stk.back());
        }
        
    }
    return 0;
}
