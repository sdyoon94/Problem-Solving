#include <bits/stdc++.h>
#define MAX 11
using namespace std;

int n, gmin = 1000000007, gmax=-1000000007;
int chk[4], numOperator[4], num[MAX], expression[MAX-1];

int Calculate(){
    int result = num[0];
    for(int i=0; i<n-1; i++){
        if(expression[i]==0) result+=num[i+1];
        if(expression[i]==1) result-=num[i+1];
        if(expression[i]==2) result*=num[i+1];
        if(expression[i]==3) result/=num[i+1];
    }
    return result;
}

void Make_expression(int cur){
    if(cur==n-1){
        int result=Calculate();
        if(gmin>result) gmin = result;
        if(gmax<result) gmax = result;
        return;
    }
    else{
        for(int i=0; i<4; i++){
            if(chk[i]<numOperator[i]){
                chk[i]++;
                expression[cur]=i;
                Make_expression(cur+1);
                chk[i]--;
            }
        }
    }
}

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++) scanf("%d", &num[i]);
    for(int i=0; i<4; i++) scanf("%d", &numOperator[i]);
    Make_expression(0);
    printf("%d\n%d\n", gmax, gmin);
    return 0;
}
