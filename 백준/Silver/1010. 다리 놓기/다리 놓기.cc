#include <stdio.h>

int comb(int a, int b);

int main()
{
	int t,n,m;
	
	scanf("%d",&t);

	while(t--){
		scanf("%d %d",&n,&m);
		printf("%d\n",comb(m,n));
	}

	return 0;
}

int comb(int a, int b)
{
	int i,combi=1;

	if(b>a/2)
		b=a-b;
	for(i=1;i<=b;i++){
		combi*=a-i+1;
		combi/=i;
	}

	return combi;
}