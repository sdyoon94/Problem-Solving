#include <stdio.h>
#include <math.h>

long double get_gcd(int a, int b);

int main(){
	int R,G;
	int i=0,j=1,n=0;
	int c[100000];

	scanf("%d %d",&R,&G);

	for(i=0;j<=(int)sqrt(get_gcd(R,G));j++){
		if((int)get_gcd(R,G)%j==0){
			c[i]=j;
			i++;
		}
		else
			continue;
	}
	
	if((int)sqrt(get_gcd(R,G))*(int)sqrt(get_gcd(R,G))==get_gcd(R,G)){
		n=2*i-1;
		for(i=0;i<n/2;i++){
			c[n-i-1]=(int)get_gcd(R,G)/c[i];
		}
		c[n/2]=(int)sqrt(get_gcd(R,G));
	}

	else{
		n=2*i;
		for(i=0;i<n/2;i++){
			c[n-i-1]=(int)get_gcd(R,G)/c[i];
		}
	}
	for(i=0;i<n;i++){
		printf("%d %d %d\n",c[i],R/c[i],G/c[i]);
	}

	return 0;
}

long double get_gcd(int a, int b)
{
	int t;
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