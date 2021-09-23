#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    scanf("%d", &T);
    while(T--){
        int repeat;
        char S[23];
        scanf("%d %s", &repeat, S);
        for(int i=0; S[i]!='\0'; i++){
            for(int j=0; j<repeat; j++) printf("%c",S[i]);
        }
        printf("\n");
    }
    return 0;
}
