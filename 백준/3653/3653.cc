#include <bits/stdc++.h>

using namespace std;

int seg_init(int start, int end, int index, vector<int> &A, vector<int> &B){
    if(start==end){
        return B[index] = A[start];
    }
    else{
        int mid = (start + end)/2;
        return B[index] = seg_init(start,mid, index*2, A, B) + seg_init(mid+1, end, index*2+1, A, B);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T; cin >> T;
    while(T--){
        int n, m; cin >> n >> m;
        vector<int> v(n+m), where(n+1);
        for(int i=m; i<n+m; i++){
            v[i]=1;
            where[i-n+1]=i;
        }
        vector<int> seg_tree(4*(n+m));
        seg_init(0, n+m-1, 1, v, seg_tree);
    }
    return 0;
}
