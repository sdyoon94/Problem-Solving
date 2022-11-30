#include <bits/stdc++.h>

using namespace std;

int func(vector<int> &tree, int target){
    long long start = 0, end = tree[0];
    while(start<=end){
        long long mid = (start + end) / 2, sum = 0;
        for(auto i : tree){
            if(mid>=i) break;
            else sum+=i-mid; 
        }
        if(sum>target) start=mid+1;
        else if(sum<target) end=mid-1;
        else return mid;
    }
    return end;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M; cin >> N >> M;
    vector<int> tree(N);
    for(int i=0; i<N; i++) cin >> tree[i];
    sort(tree.rbegin(), tree.rend());
    cout << func(tree, M) << '\n';
    return 0;
}
