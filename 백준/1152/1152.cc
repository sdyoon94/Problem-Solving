#include <bits/stdc++.h>

using namespace std;

int main(){
    char S[1000007];
    int num=1, i=0;
    scanf("%[^\n]s",S);
    if(S[0]==' ') i=1;
    if(S[0]=='\0' || (S[0]==' ' && S[1]=='\0')){
        printf("0\n");
        return 0;
    }
    for(; S[i]!='\0'; i++){
        if(S[i]==' ' && S[i+1]!='\0') num++;
    }
    printf("%d\n", num);
    
    return 0;
}