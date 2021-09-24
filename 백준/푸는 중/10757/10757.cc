#include <bits/stdc++.h>

using namespace std;

void reverse(char* str, int len){
    len--;
    for(int i=0; i<len/2; i++){
        char tmp=str[i];
        str[i]=str[len-i];
        str[len-i]=tmp;
    }
}

int main(){
    char A[10007]={0}, B[10007]={0}, sum[10007]={0};
    int A_len, B_len, sum_len;
    scanf("%s %s", A, B);
    A_len=strlen(A);
    B_len=strlen(B);
    sum_len=(A_len > B_len) ? A_len : B_len;
    reverse(A, A_len);
    reverse(B, B_len);
    for(int i=0; i<sum_len; i++){
        if(A_len>i && B_len>i) sum[i]+= (A[i] + B[i] - '0');
        else sum[i]+=A[i]+B[i];
        if(sum[i]>'9'){
            sum[i]-=10;
            sum[i+1]++;
        }
    }
    if(sum[sum_len]!='\0'){
        sum[sum_len]+='0';
        sum_len++;
    }
    for(int i=sum_len-1; i>=0; i--){
        printf("%c",sum[i]);
    }
    printf("\n");
    return 0;
}