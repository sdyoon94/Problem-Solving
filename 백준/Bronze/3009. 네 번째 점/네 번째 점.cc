#include <bits/stdc++.h>

using namespace std;

int main(){
    bool ans_x[1001]={false}, ans_y[1001]={false};
    int x, y, n=3;
    while(n--){
        scanf("%d %d", &x, &y);
        ans_x[x]=!ans_x[x];
        ans_y[y]=!ans_y[y];
    }
    for(int i=1; i<1001; i++){
        if(ans_x[i]) printf("%d ", i);
    }
    for(int i=1; i<1001; i++){
        if(ans_y[i]) printf("%d\n", i);
    }
    return 0;
}
