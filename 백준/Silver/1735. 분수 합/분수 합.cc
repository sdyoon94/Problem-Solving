#include <stdio.h>

long long get_gcd(long long a, long long b);

int main()
{
	long long A1,B1,A2,B2,A3=0,B3=0,i=0;

	scanf("%lld %lld",&A1,&B1);
	scanf("%lld %lld",&A2,&B2);
	A1*=B2;
	A2*=B1;
	B1*=B2;
	B2=B1;
	A3=A1+A2;
	B3=B1;
	i=get_gcd(A3,B1);
	A3/=i;
	B3=B1/i;
	printf("%lld %lld\n",A3,B3);

	return 0;
}

long long get_gcd(long long a, long long b)
{
	long long t;
	while(b!=0){
		a=a%b;
		if(b>a){
			t=a;
			a=b;
			b=t;
		}
	}

	return a;
}