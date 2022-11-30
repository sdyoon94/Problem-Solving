#include <bits/stdc++.h>
#define MAX 64

using namespace std;

int N, paper[MAX][MAX];

void func(int x_fir, int x_las, int y_fir, int y_las){
    bool chk=true;
    int col=paper[x_fir][y_fir];
    for(int i=x_fir; i<x_las; i++){
        for(int j=y_fir; j<y_las; j++){
            if(paper[i][j]!=col){
                chk=false;
                break;
            }
        }
        if(!chk) break;
    }
    if(chk){
        cout << col;
        return;
    }
    cout << '(';
    func(x_fir, (x_fir + x_las)/2, y_fir, (y_fir + y_las)/2);
    func(x_fir, (x_fir + x_las)/2, (y_fir + y_las)/2, y_las);
    func((x_fir + x_las)/2, x_las, y_fir, (y_fir + y_las)/2);
    func((x_fir + x_las)/2, x_las, (y_fir + y_las)/2, y_las);
    cout << ')';
    return;
}

void input(){
    cin >> N;
    for(int i=0; i<N; i++){
        string tmp; cin >> tmp;
        for(int j=0; j<N; j++){
            paper[i][j]=tmp[j]-'0';
        }
    }
    return;
}

void run(){
    input();
    func(0, N, 0, N);
    cout << '\n';
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
