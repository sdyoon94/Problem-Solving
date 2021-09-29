#include <bits/stdc++.h>
#define MAX 1000007

using namespace std;

char input[MAX], answer[MAX/3];

int main(){
    scanf("%s", input);
    int len=strlen(input)-1;
    for(int i=0; i<=len/2; i++){
        char tmp=input[i];
        input[i]=input[len-i];
        input[len-i]=tmp;
    }
    for(int i=0; i<=len; i++){
        input[i]-='0';
    }
    for(int i=0; i<=len; i+=3){
        answer[i/3]=input[i]+input[i+1]*2+input[i+2]*4;
    }
    for(int i=len/3; i>=0; i--){
        printf("%c",answer[i]+'0');
    }
    printf("\n");

    return 0;
}
