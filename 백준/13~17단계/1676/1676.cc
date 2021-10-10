#include <bits/stdc++.h>

using namespace std;

int main(){
    int N; scanf("%d", &N);
    int two=0, five=0;
    for(int i=2; i<=N; i++){
        int num=i;
        while(num%2==0){
            two++;
            num/=2;
        }
        while(num%5==0){
            five++;
            num/=5;
        }
    }
    printf("%d\n", min(two, five));
    return 0;
}
