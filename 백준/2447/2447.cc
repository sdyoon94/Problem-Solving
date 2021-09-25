#include <bits/stdc++.h>

using namespace std;

void star(char **stars, int N, int x, int y){
    if(N==3){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                stars[x+i][y+j]='*';
            }
        }
    }
    else{
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                star(stars, N/3, x+i*N/3, y+j*N/3);
            }
        }
    }
}

int main(){
    int N;
    scanf("%d", &N);
    char **stars;
    stars = new char*[N];
    for(int i=0; i<N; i++){
        stars[i] = new char[N];
    }
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            stars[i][j]=' ';
        }
    } 
    star(stars, N, 0, 0);
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            printf("%c", stars[i][j]);
        }
        printf("\n");
    }
    return 0;
}
