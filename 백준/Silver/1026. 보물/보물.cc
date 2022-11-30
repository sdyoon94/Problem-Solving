#include <stdio.h>

int main(){
	int A[50], B[50];
	int N=0,i=0,tmp=0,j=0,S=0;

	scanf("%d",&N);

	for(i=0;i<N;i++){
		scanf("%d",&A[i]);
	}
	
	for(i=0;i<N;i++){
		scanf("%d",&B[i]);
	}

	for(j=0;j<N;j++){
		for(i=0;i<N;i++){
			if(A[i]<A[j]){
				tmp=A[i];
				A[i]=A[j];
				A[j]=tmp;
			}
		}
	}

	for(j=0;j<N;j++){
		for(i=0;i<N;i++){
			if(B[i]>B[j]){
				tmp=B[i];
				B[i]=B[j];
				B[j]=tmp;
			}
		}
	}

	for(i=0;i<N;i++){
		S+=A[i]*B[i];
	}

	printf("%d",S);

	return 0;
}