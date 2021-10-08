#include <bits/stdc++.h>

using namespace std;

int solution(int n){
    int answer = 0;
    for(answer=2; answer<n; answer++){
        if(n%answer==1) break;
    }
    return answer;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int answer = solution(10);
}
