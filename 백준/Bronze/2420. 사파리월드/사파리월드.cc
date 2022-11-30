#include <stdio.h>

int main(){
	long long a=0,b=0;

	scanf("%lld %lld",&a,&b);
	printf("%lld",a>b? a-b : b-a);

	return 0;
}