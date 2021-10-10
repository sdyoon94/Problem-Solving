#include <bits/stdc++.h>

using namespace std;

int main(){
    while(1){
        string str;
        vector<char> bal;
        bool chk=true;
        getline(cin, str);
        if(str.length()==1&&str[0]=='.') break;
        for(auto i:str){
            if(i=='(') bal.push_back(i);
            else if(i==')'){
                if(!bal.empty()&&bal.back()=='(') bal.pop_back();
                else{
                    chk=false;
                    break;
                }
            }
            else if(i=='[') bal.push_back(i);
            else if(i==']'){
                if(!bal.empty()&&bal.back()=='[') bal.pop_back();
                else{
                    chk=false;
                    break;
                }
            }
        }
        if(chk&&bal.empty()) cout << "yes\n";
        else cout << "no\n";
    }
    return 0;
}
