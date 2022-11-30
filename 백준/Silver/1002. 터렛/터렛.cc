#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    cin >> T;
    while(T--){
        int x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        if(x1==x2 && y1==y2 && r1==r2){
            printf("-1\n");
            continue;
        }
        int dis = pow((x2-x1),2) + pow((y2-y1),2);
        if(dis == pow((r2-r1),2) || dis == pow((r2+r1),2)){
            printf("1\n");
            continue;
        }
        if(dis > pow((r2-r1),2) && dis < pow((r2+r1),2)){
            printf("2\n");
            continue;
        }
        else{
            printf("0\n");
            continue;
        }
    }
    return 0;
}
