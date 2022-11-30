#include <bits/stdc++.h>

using namespace std;

int func(vector<long long> &lan, long long start, long long end, long long target){
    long long mid = (start + end)/2, sum=0;
    if(mid==start){
        for(auto i : lan) sum+=i/end;
        if(sum<target) return start;
        else return end;
    }
    for(auto i : lan) sum+=i/mid;
    if(sum<target){
        end=mid;
        return func(lan, start, end, target);
    }
    else{
        start=mid;
        return func(lan, start, end, target);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long K, N; cin >> K >> N;
    vector<long long> lan(K);
    for(int i=0; i<K; i++) cin >> lan[i];
    sort(lan.rbegin(),lan.rend());
    cout << func(lan, 1, lan[0], N) << '\n';
    return 0;
}