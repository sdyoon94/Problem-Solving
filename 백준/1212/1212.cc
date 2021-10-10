#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string input, answer;
    cin >> input;
    for(int i=0; input[i]!='\0'; i++){
        char tmp[3];
        int a = input[i] - '0';
        for(int j=2; j>=0; j--){
            tmp[j]=a%2 + '0';
            a/=2;
        }
        for(auto i : tmp) answer.push_back(i);
    }
    while(answer[0]=='0') answer.erase(answer.begin(),answer.begin()+1);
    if(answer.size()==0) cout << "0\n";
    else cout << answer << '\n';
    return 0;
}
