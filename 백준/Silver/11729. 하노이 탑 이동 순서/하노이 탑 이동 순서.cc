#include <bits/stdc++.h>

using namespace std;

void hanoi(vector<pair<int, int>> *process, int from, int to, int n){
    if(n==1) process->push_back(make_pair(from, to));
    else{
        hanoi(process, from, (6 - from - to), n-1);
        process->push_back(make_pair(from, to));
        hanoi(process, (6 - from - to), to, n-1);
    }
}

int main(){
    vector<pair<int, int>> answer;
    int n;
    scanf("%d", &n);
    hanoi(&answer, 1, 3, n);
    printf("%d\n", (int)answer.size());
    for(auto i : answer){
        printf("%d %d\n", i.first, i.second);
    }
    return 0;
}
