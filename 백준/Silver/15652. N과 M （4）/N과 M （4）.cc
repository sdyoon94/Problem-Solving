#include <bits/stdc++.h>

using namespace std;

void bt(int N, int M, int cur, vector<int> seq, vector<bool> chk){
    if(M==cur){
        for(int i=0; i<M; i++){
            printf("%d ", seq[i]);
        }
        printf("\n");
        return;
    }
    else{
        for(int i=1; i<=N; i++){
            if(!chk[i]){
                seq[cur]=i;
                bt(N, M, cur+1, seq, chk);
                chk[i]=true;
            }
        }
    }
}

int main(){
    int N, M;
    scanf("%d %d", &N, &M);
    vector<int> seq(M, 0);
    vector<bool> chk(N+1, 0);
    bt(N, M, 0, seq, chk);
    return 0;
}
