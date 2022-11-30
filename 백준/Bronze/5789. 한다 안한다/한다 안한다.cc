#include <stdio.h>

int main()
{
	int n,i;
	char number[1000]={0};

	scanf("%d",&n);

	while(n--)
	{
		scanf("%s",number);
		for(i=0;number[i]!='\0';i++){}
		if(number[i/2]==number[i/2-1])
			printf("Do-it\n");
		else
			printf("Do-it-Not\n");
		for(i=0;i<1000;i++)
			number[i]=0;
			}

	return 0;
}