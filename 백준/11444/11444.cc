#include <bits/stdc++.h>
#define P 1000000007
#define ll long long

using namespace std;

typedef struct Matix{
    ll mat[2][2]={1, 1, 1, 0};
}M;

ll N;

M mult(M A, M B){
    M ret;
    for(int i=0; i<2; i++){
        for(int j=0; j<2; j++){
            for(int k=0; k<2; k++){
                if(k==0) ret.mat[i][j]=(A.mat[i][k]*B.mat[k][j])%P;
                else ret.mat[i][j]=(ret.mat[i][j]+(A.mat[i][k]*B.mat[k][j]%P))%P;
            }
        }
    }
    return ret;
}

M fibo(ll n){
    M tmp, fibo1;
    if(n==1) return fibo1;
    tmp=fibo(n/2);
    if(n%2==1){
        return mult(mult(tmp, tmp), fibo1);
    }
    else{
        return mult(tmp, tmp);
    }
}

void input(){
    cin >> N;
}

void run(){
    input();
    cout << fibo(N).mat[1][0]%P << '\n';
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
