#include <bits/stdc++.h>

using namespace std;

int main(){
    char S[1000007];
    int alpha[26]={0};
    pair<int, char> max(0, 0);
    scanf("%s",S);
    for(int i=0; S[i]!='\0'; i++){
        if('a'<=S[i] && S[i]<='z') S[i]-=32;
        alpha[S[i]-'A']++;
    }
    for(int i=0; i<26; i++){
        if(alpha[i]>max.first){
            max.first=alpha[i];
            max.second=i+'A';
        }
        else if(alpha[i]==max.first) max.second='?';
    }
    printf("%c\n", max.second);
    return 0;
}
