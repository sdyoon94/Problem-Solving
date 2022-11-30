#include <stdio.h>
int main()
{
	int N=0;
	int a=0, i=0;

	scanf("%d",&N);

	a=N;

	while(1){
		i++;
		a=10*(a%10)+((a/10)+(a%10))%10;
		if(a==N){
			break;
		}
	}

	printf("%d",i);

	return 0;
}