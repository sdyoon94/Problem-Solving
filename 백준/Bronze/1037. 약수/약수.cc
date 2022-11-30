#include <stdio.h>
int main()
{
	int N[50];
	int num=0, a=0, n=0, i=0, j=0, tmp=0;

	scanf("%d",&num);

	for(i=0;i<num;i++){
		scanf("%d",&N[i]);
	}


	for(i=0;i<num;i++){
		for(j=0;j<num;j++){
			if(N[i]<N[j]){
				tmp=N[i];
				N[i]=N[j];
				N[j]=tmp;
			}
		}
	}

	n= N[0]*N[num-1];

	printf("%d",n);

	return 0;
}