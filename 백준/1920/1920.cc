#include <bits/stdc++.h>

using namespace std;

int BS(vector<int> &arr, int &val, int left, int right){
    int mid = (left + right)/2;
    if(arr[mid]==val) return 1;
    else if(left==mid) return 0;
    else if(arr[mid]>val) return BS(arr, val, left, mid);
    else return BS(arr, val, mid, right);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    vector<int> A;

    cin >> N;
    while(N--){
        int tmp;
        cin >> tmp;
        A.push_back(tmp);
    }
    sort(A.begin(),A.end());

    cin >> M;
    while(M--){
        int tmp;
        cin >> tmp;
        cout << BS(A, tmp, 0, A.size()) << "\n";
    }

    return 0;
}
