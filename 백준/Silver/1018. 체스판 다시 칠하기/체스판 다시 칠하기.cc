#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, M, ans=100;
    scanf("%d %d", &N, &M);
    char **board;
    board = new char*[N];
    for(int i=0; i<N; i++){
        board[i] = new char[M+1];
        scanf("%s", board[i]);
    }
    char chess[8][8];
    for(int i=0; i<8; i++){
        for(int j=0; j<8; j++){
            if((i+j)%2==0){
                chess[i][j]='W';
            }
            else{
                chess[i][j]='B';
            }
        }
    }
    for(int i=0; i<=N-8; i++){
        for(int j=0; j<=M-8; j++){
            int paint=0;
            for(int k=0; k<8; k++){
                for(int l=0; l<8; l++){
                    if(board[i+k][j+l]!=chess[k][l]) paint++;
                }
            }
            if(paint>32) paint= 64-paint;
            if(ans>paint) ans=paint;
        }
    }
    printf("%d\n", ans);
    return 0;
}
