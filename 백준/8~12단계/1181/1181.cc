#include <bits/stdc++.h>

using namespace std;
bool compare(string a, string b){
    int len_a=a.length(), len_b=b.length();
    if(len_a==len_b){
        for(int i=0; i<len_a; i++){
            if(a[i]==b[i]) continue;
            return a[i] < b[i];
        }
    }
    else return len_a < len_b;
}
int main(){
    int N;
    map<string, bool> chk;
    scanf("%d", &N);
    vector<string> word;
    for(int i=0; i<N; i++){
        string tmp;
        cin >> tmp;
        if(!chk[tmp]){
            word.push_back(tmp);
            chk[tmp]=true;
        }
    }
    sort(word.begin(), word.end(), compare);
    for(auto i : word) cout << i << endl;
    return 0;
}
