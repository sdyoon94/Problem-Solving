#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, maxi=0, mini=1000001;
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        int tmp;
        scanf("%d", &tmp);
        if(tmp<mini) mini=tmp;
        if(tmp>maxi) maxi=tmp;
    }
    printf("%d\n", mini*maxi);
    return 0;
}
