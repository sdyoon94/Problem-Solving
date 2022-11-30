#include <bits/stdc++.h>
#define MAX 999
using namespace std;

int dx[4]={1, 0, -1, 0};
int dy[4]={0, 1, 0, -1};
int N, obj, dir=0, x=0, y=0;
int snail[MAX][MAX];

bool valid(){
    if(x+dx[dir]<0||x+dx[dir]>=N) return false;
    else if(y+dy[dir]<0||y+dy[dir]>=N) return false;
    else if(snail[x+dx[dir]][y+dy[dir]]!=0) return false;
    return true;
}

void turn(){
    dir=(dir+1)%4;
}

int main(){
    scanf("%d %d", &N, &obj);
    for(int i=N*N; i>=1; i--){
        snail[x][y]=i;
        if(!valid()) turn();
        x+=dx[dir]; y+=dy[dir];
    }
    pair<int, int> obj_ord;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            printf("%d ", snail[i][j]);
            if(snail[i][j]==obj) obj_ord.first=i+1, obj_ord.second=j+1;
        }
        printf("\n");
    }
    printf("%d %d\n", obj_ord.first, obj_ord.second);
    return 0;
}
