#include <cstdio>
#include <algorithm>
#include <cstring>
#include <functional>

using namespace std;

int main()
{
	char N[11];

	scanf( "%s" , N );
	sort( N , N + strlen(N) , greater<int>() );
	printf( "%s" , N);

	return 0;
}