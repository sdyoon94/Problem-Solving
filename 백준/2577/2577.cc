#include <bits/stdc++.h>

using namespace std;

int main(){
    int mul=1, tmp;
    int arr[10]={0};
    while(scanf("%d", &tmp)!=EOF) mul*=tmp;
    while(mul){
        arr[mul%10]++;
        mul/=10;
    }
    for(int i=0; i<10; i++) printf("%d\n",arr[i]);

    return 0;
}