#include <stdio.h>

int min(int a, int b);

int main(){
	int a=0, b=0;

	scanf("%d %d",&a,&b);
	printf("%d\n",min(a,b));

	return 0;
}

int min(int a, int b){
	return a-b;
}