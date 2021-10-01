#include <bits/stdc++.h>
#define MAX 128

using namespace std;

int N, paper[MAX][MAX], color[2];

void func(int x_fir, int x_las, int y_fir, int y_las){
    bool chk=true;
    int col=paper[x_fir][y_fir];
    for(int i=x_fir; i<=x_las; i++){
        for(int j=y_fir; j<=y_las; j++){
            if(paper[i][j]!=col){
                chk=false;
                break;
            }
        }
        if(!chk) break;
    }
    if(chk){
        color[col]++;
        return;
    }
    func(x_fir, (x_fir + x_las)/2, y_fir, (y_fir + y_las)/2);
    func(x_fir, (x_fir + x_las)/2, (y_fir + y_las)/2 + 1, y_las);
    func((x_fir + x_las)/2 + 1, x_las, y_fir, (y_fir + y_las)/2);
    func((x_fir + x_las)/2 + 1, x_las, (y_fir + y_las)/2 + 1, y_las);
    return;
}

void input(){
    cin >> N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> paper[i][j];
        }
    }
    return;
}

void print(){
    for(int i=0; i<2; i++) cout << color[i] << '\n';
    return;
}

void run(){
    input();
    func(0, N-1, 0, N-1);
    print();
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    run();

    return 0;
}
