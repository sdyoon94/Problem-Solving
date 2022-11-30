#include <stdio.h>
#include <math.h>

long long find_n(long long S);

int main()
{
	long long S=0;

	scanf("%lld",&S);

	printf("%lld\n",find_n(S));

	return 0;
}

long long find_n(long long S)
{
	long double n;

	n=sqrt((long double)2*S+0.25);
	n=n-0.5;

	return (long long)n;
}