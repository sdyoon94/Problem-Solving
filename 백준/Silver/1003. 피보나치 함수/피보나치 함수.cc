#include <bits/stdc++.h>

using namespace std;

int main(){
    int T;
    scanf("%d", &T);
    pair<int, int> fibo[41];
    fibo[0] = {1, 0};
    fibo[1] = {0, 1};
    for(int i=2; i<41; i++){
        fibo[i].first = fibo[i-2].first + fibo[i-1].first;
        fibo[i].second = fibo[i-2].second + fibo[i-1].second;
    }
    while(T--){
        int N;
        scanf("%d", &N);
        printf("%d %d\n", fibo[N].first, fibo[N].second);
    }
    return 0;
}
