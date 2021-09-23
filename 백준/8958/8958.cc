#include <bits/stdc++.h>

using namespace std;

int main(){
    int N;
    char input[85];
    scanf("%d", &N);
    while(N--){
        int score=0, point=1;
        scanf("%s",input);
        for(int i=0;input[i]!='\0';i++){
            if(input[i]=='O'){
                score+=point;
                point++;
            }
            else point=1;
        }
        printf("%d\n", score);
    }
    return 0;
}