#include <bits/stdc++.h>

using namespace std;

int w[21][21][21];

void dp(int a, int b, int c){
    if(a==0 || b==0 || c==0){
        w[a][b][c] = 1;
    }
    else if(a<b&&b<c){
        w[a][b][c] = w[a][b][c-1] + w[a][b-1][c-1] - w[a][b-1][c];
    }
    else{
        w[a][b][c] = w[a-1][b][c] + w[a-1][b-1][c] + w[a-1][b][c-1] - w[a-1][b-1][c-1];
    }
}

int main(){
    for(int i=0; i<=20; i++){
        for(int j=0; j<=20; j++){
            for(int k=0; k<=20; k++){
                dp(i, j, k);
            }
        }
    }
    while(1){
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        if(a==-1&&b==-1&&c==-1) break;
        if(a<=0 || b<=0 || c<=0){
            printf("w(%d, %d, %d) = %d\n", a, b, c, 1);

        }
        else if(a>20 || b>20 || c>20){
            printf("w(%d, %d, %d) = %d\n", a, b, c, w[20][20][20]);
        }
        else{
            printf("w(%d, %d, %d) = %d\n", a, b, c, w[a][b][c]);
        }
    }
    return 0;
}
