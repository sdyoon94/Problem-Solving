#include <bits/stdc++.h>

using namespace std;

bool cmp(pair<int, int> A, pair<int, int> B){
    if(A.second==B.second) return A.first<B.first;
    else return A.second<B.second;
}

int main(){
    int N;
    scanf("%d", &N);
    vector<pair<int, int>> meeting;
    for(int i=0; i<N; i++){
        pair<int, int> tmp;
        scanf("%d %d", &tmp.first, &tmp.second);
        meeting.push_back(tmp);
    }
    sort(meeting.begin(), meeting.end(), cmp);
    int count=0, time=0;
    for(int i=0; i<N; i++){
        if(time<=meeting[i].first){
            time=meeting[i].second;
            count++;
        }
    }
    printf("%d\n", count);
    return 0;
}
