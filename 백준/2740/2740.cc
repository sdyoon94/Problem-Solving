#include <bits/stdc++.h>
#define MAX 100

using namespace std;

int N, M, K;
int A[MAX][MAX], B[MAX][MAX], ans[MAX][MAX];

void input(){
    cin >> N >> M;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> A[i][j];
        }
    }
    cin >> M >> K;
    for(int i=0; i<M; i++){
        for(int j=0; j<K; j++){
            cin >> B[i][j];
        }
    }
}

void print(){
    for(int i=0; i<N; i++){
        for(int j=0; j<K; j++){
            cout << ans[i][j] << ' ';
        }
        cout << '\n';
    }
}

int func(int i, int j){
    int ans=0;
    for(int k=0; k<M; k++){
        ans+=A[i][k]*B[k][j];
    }
    return ans;
}

void run(){
    input();
    for(int i=0; i<N; i++){
        for(int j=0; j<K; j++){
            ans[i][j]=func(i, j);
        }
    }
    print();
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();
    
    return 0;
}
