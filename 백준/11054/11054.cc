#include <bits/stdc++.h>
#define MAX 1007

using namespace std;

int arr[MAX], arr_r[MAX], dpA[MAX], dpB[MAX];

int main(){
    int N; scanf("%d", &N);
    for(int i=0; i<N; i++){
        int tmp; scanf("%d", &tmp);
        arr[i]=tmp;
        arr_r[N-1-i]=tmp;
    }
    fill(dpA, dpA+N, 1);
    fill(dpB, dpB+N, 1);
    for(int i=1; i<N; i++){
        for(int j=0; j<i; j++){
            if(arr[j]<arr[i]) dpA[i]=max(dpA[i], dpA[j]+1);
            if(arr_r[j]<arr_r[i]) dpB[i]=max(dpB[i], dpB[j]+1);
        }
    }
    int ans=0;
    for(int i=0; i<N; i++){
        ans=max(ans, dpA[i]+dpB[N-1-i]-1);
    }
    printf("%d\n", ans);
    return 0;
}
