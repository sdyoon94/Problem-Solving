#include <stdio.h>

int main()
{
	int N,i;

	scanf( "%d" , &N );

	N--;
	for( i=1 ; 3 * i * ( i - 1 ) < N ; i++ ){}

	printf( "%d" , i );

	return 0;
}