#include <bits/stdc++.h>
#define MAX 9

using namespace std;

int board[MAX][MAX];
bool finish = false;

bool ValidTest(int val, int row, int col){
    for(int i=0;i<MAX;i++){
        if(board[row][i]==val) return false;
        if(board[i][col]==val) return false;
    }
    for(int i=(row/3)*3; i<(row/3)*3+3; i++){
        for(int j=(col/3)*3; j<(col/3)*3+3; j++){
            if(board[i][j]==val) return false;
        }
    }
    return true;
}

void Sudoku(int row){
    
    for(int i=row; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            if(board[i][j]==0){
                for(int k=1; k<=MAX; k++){
                    if(!finish && ValidTest(k, i, j)){
                        board[i][j]=k;
                        Sudoku(i);
                        board[i][j]=0;
                    }
                }
                return;
            }
        }
    }
    finish = true;
    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            printf("%d ", board[i][j]);
        }
        printf("\n");
    }
}

int main(){
    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            scanf("%d", &board[i][j]);
        }
    }
    Sudoku(0);
    return 0;
}