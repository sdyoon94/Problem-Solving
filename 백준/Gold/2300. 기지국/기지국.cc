#include <iostream>
#include <algorithm>

using namespace std;

typedef struct location{
	int x;
	int y;
}location;

bool cf( location a , location b );
int v( int a , int b , int max );
int d[10009];
location loca[10009];
int main()
{
	int N , min = 987654321 , max=0;

	for( int i = 1 ; i < 10009 ; i++ )
		d[i] = 987654321;

	cin >> N;

	for( int i = 1 ; i <= N ; i++ )
		cin >> loca[i].x >> loca[i].y;
	for( int i = 1 ; i <= N ; i++ ){
		if( loca[i].y < 0 )
			loca[i].y *= -1;
		loca[i].y *= 2;
	}
	sort( loca + 1 , loca + N + 1 , cf );

	for( int i = 1 ; i <= N ; i ++ , min = 987654321 , max = 0){
		for( int j = 1 ; j <= i ; j ++ ){
			if( max < loca[ i - j + 1 ].y )
				max = loca[ i - j + 1 ].y;
			if( min > d[ i - j ] + v( i , i - j + 1 , max ) )
				min = d[ i - j ] + v( i , i - j + 1 , max );
		}
		d[ i ] = min;
	}

	cout << d[ N ] << endl;

	return 0;
}

bool cf( location a , location b ){
	return a.x < b.x;
}

int v( int a , int b , int max){
	if( max < loca[a].x - loca[b].x )
		max = loca[a].x - loca[b].x;
	return max;
}