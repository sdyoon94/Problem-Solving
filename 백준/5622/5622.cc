#include <bits/stdc++.h>

using namespace std;

int main(){
    char input[16];
    scanf("%s",input);
    int time=0;
    for(int i=0; input[i]!='\0'; i++){
        if('A'<=input[i] && input[i]<='C') time+=3;
        else if('D'<=input[i] && input[i]<='F') time+=4;
        else if('G'<=input[i] && input[i]<='I') time+=5;
        else if('J'<=input[i] && input[i]<='L') time+=6;
        else if('M'<=input[i] && input[i]<='O') time+=7;
        else if('P'<=input[i] && input[i]<='S') time+=8;
        else if('T'<=input[i] && input[i]<='V') time+=9;
        else time+=10;
    }
    printf("%d\n", time);
    return 0;
}
