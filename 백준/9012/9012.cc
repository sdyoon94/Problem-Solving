#include <bits/stdc++.h>

using namespace std;

int main(){
    int T; cin >> T;
    while(T--){
        bool chk=true;
        int VPS=0;
        char input[51]; cin >> input;
        for(int i=0; input[i]!='\0'; i++){
            if(input[i]=='(') VPS++;
            else if(input[i]==')') VPS--;
            if(VPS<0){
                chk=false;
                break;
            }
        }
        if(chk&&VPS==0) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
