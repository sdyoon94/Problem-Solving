#include <bits/stdc++.h>

using namespace std;

long long func(long long a, long long b){
    long long ans=0;
    for(long long i=b; a/i>=1; i*=b){
        ans+=a/i;
    }
    return ans;
}

int main(){
    long long n, m; scanf("%lld %lld", &n, &m);
    if(n/2<m) m=n-m;
    long long two=0, five=0;
    two = func(n, 2) - func(n-m, 2) - func(m, 2);
    five = func(n, 5) - func(n-m, 5) - func(m, 5);
    printf("%lld\n", min(two, five));
    return 0;
}
