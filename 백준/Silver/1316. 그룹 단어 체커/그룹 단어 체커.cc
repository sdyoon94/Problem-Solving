#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, num=0;
    scanf("%d",&N);
    while(N--){
        char input[101];
        bool chk[26]={false};
        scanf("%s",input);
        for(int i=0; input[i]!='\0'; i++){
            if(input[i]==input[i+1]) continue;
            if(chk[input[i]-'a']){
                num--;
                break;
            }
            chk[input[i]-'a']=true;
        }
        num++;
    }
    printf("%d\n",num);
    return 0;
}
