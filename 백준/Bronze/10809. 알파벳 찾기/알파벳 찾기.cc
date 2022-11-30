#include <bits/stdc++.h>

using namespace std;

int main(){
    int alpha[26];
    for(int i=0; i<26; i++){
        alpha[i]=-1;
    }
    char S[107];
    scanf("%s", S);
    for(int i=0; S[i]!='\0'; i++){
        if(alpha[S[i]-'a']==-1) alpha[S[i]-'a']=i;
    }
    for(int i=0; i<26; i++) printf("%d ", alpha[i]);

    return 0;
}
