#include <bits/stdc++.h>
#define ll long long

using namespace std;

ll N, B, **M;

ll** mult(ll **X, ll **Y){
    ll **tmp = new ll *[N];
    for(int i=0; i<N; i++) tmp[i] = new ll[N];
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            for(int k=0; k<N; k++){
                if(k==0) tmp[i][j] = X[i][k]*Y[k][j]%1000;
                else tmp[i][j] = (tmp[i][j]+X[i][k]*Y[k][j]%1000)%1000;
            }
        }
    }
    return tmp;
}

ll** pow(ll **base, ll exponent){
    ll **tmp = new ll *[N];
    for(int i=0; i<N; i++) tmp[i] = new ll[N];
    if(exponent==1){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[i][j]=base[i][j];
            }
        }
        return tmp;
    }
    else{
        tmp=pow(base, exponent/2);
        if(exponent%2==1) return mult(mult(tmp, tmp), base);
        else return mult(tmp, tmp);
    }
}

void input(){
    cin >> N >> B;
    M = new ll *[N];
    for(int i=0; i<N; i++){
        M[i] = new ll[N];
        for(int j=0; j<N; j++){
            cin >> M[i][j];
        }
    }
}

void run(){
    input();
    ll** ans = pow(M, B);
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cout << ans[i][j]%1000 << ' ';
        }
        cout << '\n';
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
