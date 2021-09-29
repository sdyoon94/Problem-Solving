#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b){
    if(a==0) return b;
    else return gcd(b%a, a);
}

void print(int a){
    vector<int> answer;
    int sq=sqrt(a);
    answer.push_back(a);
    for(int i=2; i<=sq; i++){
        if(a%i==0){
            answer.push_back(i);
            answer.push_back(a/i);
        }
    }
    answer.erase(unique(answer.begin(),answer.end()), answer.end());
    sort(answer.begin(), answer.end());
    for(int i : answer) printf("%d ", i);
}

int main(){
    int N;
    vector<int> dif;
    scanf("%d", &N);
    int *num= new int[N];
    for(int i=0; i<N; i++){
        scanf("%d", &num[i]);
        for(int j=0; j<i; j++){
            dif.push_back(abs(num[i]-num[j]));
        }
    }
    dif.erase(unique(dif.begin(), dif.end()),dif.end());
    sort(dif.begin(),dif.end());
    int size = dif.size();
    int ans=gcd(dif[0], dif[1]);
    for(int i=2; i<size; i++){
        ans=gcd(ans, dif[i]);
    }
    print(ans);
    return 0;
}