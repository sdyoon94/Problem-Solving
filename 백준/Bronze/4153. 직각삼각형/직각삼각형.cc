#include <bits/stdc++.h>

using namespace std;

int main(){
    int a, b, c;
    cin >> a >> b >> c;
    while(a+b+c){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(a<c){
            int tmp = a;
            a = c;
            c = tmp;
        }
        if(a*a==b*b+c*c) cout << "right\n";
        else cout << "wrong\n";
        cin >> a >> b >> c;
    }
    return 0;
}
