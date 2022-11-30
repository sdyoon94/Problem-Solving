#include <bits/stdc++.h>
#define pii pair<int, int>
using namespace std;

int N;
vector<pii> v;

int distance(pii A, pii B){
    int x = A.first - B.first, y = A.second - B.second;
    return x * x + y * y;
}

int func(int start, int end){
    int mini=INT_MAX;
    int num=end-start;
    if(num<=3){
        for(int i=start; i<end; i++){
            for(int j=i+1; j<end; j++){
                mini = min(mini, distance(v[i], v[j]));
            }
        }
    }
    else{
        int mid = (start + end) / 2;
        int left = func(start, mid);
        int right = func(mid, end);
        mini = min(left, right);

        vector<pii> tmp;
        tmp.push_back({v[mid].second, v[mid].first});
        for(int i=mid-1; i>=start; i--){
            if(distance({v[mid].first, 0}, {v[i].first, 0}) >= mini) break;
            tmp.push_back({v[i].second, v[i].first});
        }
        for(int i=mid+1; i<end; i++){
            if(distance({v[mid].first, 0}, {v[i].first, 0}) >= mini) break;
            tmp.push_back({v[i].second, v[i].first});
        }
        sort(tmp.begin(), tmp.end());
        int size=tmp.size();
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(distance({tmp[i].first, 0}, {tmp[j].first, 0}) >= mini) break;
                mini = min(mini, distance(tmp[i], tmp[j]));
            }
        }
    }
    return mini;
}

void input(){
    cin >> N;
    for(int i=0; i<N; i++){
        pii tmp;
        cin >> tmp.first >> tmp.second;
        v.push_back(tmp);
    }
    return;
}

void run(){
    input();
    sort(v.begin(), v.end());
    cout << func(0, N) << '\n';
    return;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    run();
    return 0;
}
