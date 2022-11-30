#include <stdio.h>

int main()
{
	char A[50][51];
	char B[51];
	int N=0,i=0,j=0,a=0,k=0;

	scanf("%d",&N);

	for(i=0;i<N;i++){
		scanf("%s",&A[i]);
	}

	for(i=0;A[0][i]!=0;i++){
		a++;
	}

	for(j=0;j<N;j++){
		for(k=0;k<a;k++){
			if(A[0][k]!=A[j][k]){
				A[0][k]='?';
			}
		}
	}
	
	for(i=0;i<a;i++){
		printf("%c",A[0][i]);
	}

	printf("\n");

	return 0;
}