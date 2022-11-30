#include <stdio.h>

int main(){
	int white[102][102] = { 0 };
	int black[2] , n , i , j , dulle=0;

	scanf( "%d" , &n );
	while(n--){
		scanf( "%d %d" , &black[0] , &black[1] );
		for( i = black[0] ; i < black[0] + 10 ; i++ ){
			for( j = black[1] ; j < black[1] + 10; j++ ){
				white[i][j] = 1;
			}
		}
	}

	for( i = 1 ; i <= 100 ; i++ ){
		for ( j = 1 ; j <= 100 ; j++ ){
			if( white[i][j] == 1 ){
				if( white[i-1][j] == 0 )
					dulle++;
				if( white[i+1][j] == 0 )
					dulle++;
				if( white[i][j-1] == 0 )
					dulle++;
				if( white[i][j+1] == 0 )
					dulle++;
			}
		}
	}

	printf( "%d" , dulle );

	return 0;
}