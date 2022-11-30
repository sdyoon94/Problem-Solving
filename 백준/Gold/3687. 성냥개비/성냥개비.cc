#include <bits/stdc++.h>

using namespace std;

void print(stack<int> s){
    while(!s.empty()){
        cout << s.top();
        s.pop();
    }
}

void max(int N){
    stack<int> max;
    while(N){
        if(N==3){
            max.push(7);
            N-=3;
        }
        else{
            max.push(1);
            N-=2;
        }
    }
    print(max);
}
void min(int N){
    stack<int> min;
    while(N){
        switch(N){
            case 2:
                min.push(1);
                N-=2;
                break;
            case 3:
                min.push(7);
                N-=3;
                break;
            case 4:
                min.push(4);
                N-=4;
                break;
            case 5: case 10:
                min.push(2);
                N-=5;
                break;
            case 6:
                min.push(6);
                N-=6;
                break;
            case 8: case 11: case 17:
                min.push(0);
                N-=6;
                break;
            default:
                min.push(8);
                N-=7;
                break;
        }
    }
    print(min);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T; cin >> T;
    while(T--){
        int N; cin >> N;
        min(N);
        cout << ' ';
        max(N);
        cout << '\n';
    }
    return 0;
}