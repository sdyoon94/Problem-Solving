#include <stdio.h>

int main()
{
	char A[1000001];
	int i=0,n=0;

	gets(A);

	while(1){
		for(;A[i]==' ';i++){
		}
		if(A[i]=='\0'){
			break;
		}
		n++;
		for(;A[i]!=' ';i++){
			if(A[i]=='\0'){
				break;
			}
		}
		if(A[i]=='\0'){
			break;
		}
	}

	printf("%d",n);

	return 0;
}