#include <bits/stdc++.h>

using namespace std;

void swap(int &a, int &b){
    int tmp=a;
    a=b;
    b=tmp;
}

void pop(vector<int> &h){
    int size = h.size() - 1;
    if(size==0) cout << "0\n";
    else{
        cout << h[1] << '\n';
        h[1] = h[size];
        h.pop_back();
        size--;
        int i = 1;
        while(1){
            if(i*2>size) return;
            else if(i*2+1>size){
                if(h[i]<h[2*i]) swap(h[i],h[2*i]);
                return;
            }
            if(h[i]>h[i*2]&&h[i]>h[i*2+1]) return;
            else{
                int big = h[i*2]>h[i*2+1] ? i*2 : i*2+1;
                swap(h[i],h[big]);
                i=big;
            }
        }
    }
}

void push(vector<int> &h, int num){
    h.push_back(num);
    int size = h.size() - 1;
    int i = size;
    while(1){
        if(i==1) return;
        else if(h[i]<h[i/2]) return;
        else{
            swap(h[i],h[i/2]);
            i=i/2;
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> max_heap(1);
    int N; cin >> N;
    while(N--){
        int tmp; cin >> tmp;
        if(tmp==0) pop(max_heap);
        else push(max_heap, tmp);
    }
    return 0;
}
