#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;
    unordered_map<int, int> card;
    for(int i=0; i<N; i++){
        int tmp; cin >> tmp;
        card[tmp]++;
    }
    cin >> N;
    for(int i=0; i<N; i++){
        int tmp; cin >> tmp;
        cout << card[tmp] << ' ';
    }
    cout << '\n';

    return 0;
}
