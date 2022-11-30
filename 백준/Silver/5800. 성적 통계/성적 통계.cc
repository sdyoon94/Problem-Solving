#include <stdio.h>

int arr[50]={0};

void Sort(int N)
{
	int tmp,i,j;

	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
		{
			if(arr[i]<arr[j])
			{
				tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		}
	}
}


int main()
{
	int K,N,i,Class=1,Max=0,Min=100,gap=0;

	scanf("%d",&K);
	while(K--)
	{
		scanf("%d",&N);
		for(i=0;i<N;i++)
			scanf("%d",&arr[i]);
		for(i=0;i<N;i++)
		{
			if(arr[i]<Min)
				Min=arr[i];
			if(arr[i]>Max)
				Max=arr[i];
		}
		Sort(N);
		for(i=1;i<N;i++)
			if(arr[i]-arr[i-1]>gap)
				gap=arr[i]-arr[i-1];
		printf("Class %d\n",Class++);
		printf("Max %d, Min %d, Largest gap %d\n",Max,Min,gap);
		Max=0;
		Min=100;
		gap=0;
		for(i=0;i<N;i++)
			arr[i]=0;
	}

	return 0;
}