#include <bits/stdc++.h>
#define MAX 1000

using namespace std;

int N, arr[MAX], dp[MAX];

int main(){
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        scanf("%d", &arr[i]);
        int maxi=0;
        for(int j=0; j<i; j++){
            if(arr[j]<arr[i]){
                maxi=max(maxi, dp[j]);
            }
        }
        dp[i]=maxi+1;
    }
    int ans=0;
    for(int i=0; i<N; i++) ans=max(ans, dp[i]);
    printf("%d\n",ans);
    return 0;
}
