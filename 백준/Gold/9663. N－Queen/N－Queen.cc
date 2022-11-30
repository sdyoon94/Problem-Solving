#include <bits/stdc++.h>
#define MAX 15

using namespace std;

int n, queen = 0;
int chk[MAX];

bool ValidTest(int row, int col){
    for(int i=0; i<row; i++){
       if(chk[i]==col || abs(chk[i]-col)==row-i) return false;
    }
    return true;
}

void Queen(int cur){
    if(cur==n){
        queen++;
    }
    else{
        for(int i=0; i<n; i++){
            if(ValidTest(cur, i)){
                chk[cur]=i;
                Queen(cur+1);
            }
        }
    }
}

int main(){
    scanf("%d", &n);
    Queen(0);
    printf("%d\n", queen);
    return 0;
}
