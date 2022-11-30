#include <bits/stdc++.h>
#define MAX 20
using namespace std;

int n, gmin=999999999, stat[MAX][MAX];
bool team_A[MAX]={true}, team_B[MAX];

int Calculate(){
    int sumA=0, sumB=0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(i==j) continue;
            else if(team_A[i]&&team_A[j]) sumA+=stat[i][j];
            else if(team_B[i]&&team_B[j]) sumB+=stat[i][j];
        }
    }
    return abs(sumA-sumB);
}

void MakeTeam(int cur, int nth){
    if(cur==n/2){
        int dif = Calculate();
        if(gmin>dif) gmin=dif;
        return;
    }
    else{
        for(int i=nth; i<n; i++){
            if(!team_A[i]){
                team_A[i]=true;
                team_B[i]=false;
                MakeTeam(cur+1, i);
                team_A[i]=false;
                team_B[i]=true;
            }
        }
    }
}

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            scanf("%d", &stat[i][j]);
        }
    }
    for(int i=1; i<MAX; i++) team_B[i]=true;
    MakeTeam(1, 1);
    printf("%d\n", gmin);
    return 0;
}
