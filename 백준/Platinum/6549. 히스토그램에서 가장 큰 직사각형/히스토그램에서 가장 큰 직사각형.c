#include<stdio.h>

long long int hist[1000000];

int stack[1000000];

int main()

{

	int i,n;

	int top;

	while(1)

	{

		scanf("%d",&n);

		if(n==0)

			break;

		else

		{

			top=-1;

			int htop;

			long long int maxarea=-1;

			long long int newarea;

			for(i=0;i<n;i++)

			{

				scanf("%lld",&hist[i]);	

			}

			for(i=0;i<n;i++)

			{

				if(top==-1||hist[stack[top]]<=hist[i])

				{

					++top;

					stack[top]=i;

				}

				else

				{

					while((hist[stack[top]]>hist[i])&&(top>-1))

					{

						htop=stack[top];

						top--;

						newarea= hist[htop] * ((top==-1) ? i : (i - stack[top] - 1));

						if(newarea>maxarea)

							maxarea=newarea;

					}

					top++;

					stack[top]=i;

				}

 

			}

			while(top>-1)

			{

				htop=stack[top];

				top--;

				newarea=hist[htop]*((top==-1) ? i : (i - stack[top] -1));

				if(newarea>maxarea)

					maxarea=newarea;

			}

			printf("%lld\n",maxarea);		

		}

	}

	return 0;

}
