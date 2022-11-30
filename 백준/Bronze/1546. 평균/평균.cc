#include <bits/stdc++.h>

using namespace std;

int main(){
    double sum=0, tmp, max=0, N;
    scanf("%lf",&N);
    for(int i=0; i<N; i++){
        scanf("%lf",&tmp);
        sum+=tmp;
        if(tmp>max) max=tmp;
    }
    printf("%lf",(sum*100)/(max*N));
    return 0;
}
