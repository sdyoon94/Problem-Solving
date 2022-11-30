#include <stdio.h>
#include <stdlib.h>

int One(int a, int b);

int main(){
	int n=0;
	int* a,*b;

	scanf("%d",&n);
	a=(int*)malloc(n*sizeof(int));
	b=(int*)malloc(n*sizeof(int));
	for(int i=0;i<n;i++){
		scanf("%d %d",&a[i],&b[i]);
	}
	for(int i=0;i<n;i++){
		printf("%d",One(a[i],b[i]));
		printf("\n");
	}

	return 0;
}

int One(int a, int b){
	int result=0;
	switch(a%10){
	case 0:
		result=10;
		break;
	case 1:
		result=1;
		break;
	case 2:
		switch(b%4){
		case 0:
			result=6;
			break;
		case 1:
			result=2;
			break;
		case 2:
			result=4;
			break;
		case 3:
			result=8;
			break;
		}
		break;
	case 3:
		switch(b%4){
		case 0:
			result=1;
			break;
		case 1:
			result=3;
			break;
		case 2:
			result=9;
			break;
		case 3:
			result=7;
			break;
		}
		break;
	case 4:
		switch(b%2){
		case 0:
			result=6;
			break;
		case 1:
			result=4;
			break;
		}
		break;
	case 5:
		result=5;
		break;
	case 6:
		result=6;
		break;
	case 7:
		switch(b%4){
		case 0:
			result=1;
			break;
		case 1:
			result=7;
			break;
		case 2:
			result=9;
			break;
		case 3:
			result=3;
			break;
		}
		break;
	case 8:
		switch(b%4){
		case 0:
			result=6;
			break;
		case 1:
			result=8;
			break;
		case 2:
			result=4;
			break;
		case 3:
			result=2;
			break;
		}
		break;
	case 9:
		switch(b%2){
		case 0:
			result=1;
			break;
		case 1:
			result=9;
			break;
		}
		break;
	}

	return result;
}
