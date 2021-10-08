#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    bool start=true;
    int start_i = left/n, start_j = left%n, end_i = right/n, end_j = right%n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(start) i=start_i, j=start_j, start=false;
            if(j<=i) answer.push_back(i+1);
            else answer.push_back(j+1);
            if(i==end_i&&j==end_j) return answer;
        }
    }
}

int main(){
    vector<int> answer = solution(3, 2, 5);
    for(auto i : answer) cout << i << ' ';
}