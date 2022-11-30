#include <bits/stdc++.h>

using namespace std;

int main(){
    int input, max=0, order=0;
    for(int i=1;i<=9;i++){
        scanf("%d", &input);
        if(input>max){
            max = input;
            order = i;
        }
    }
    printf("%d\n%d\n", max, order);

    return 0;
}
