#include <stdio.h>
#include <algorithm>

using namespace std;

int N, cnt = 0;
int map[25][25];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, -1, 0, 1};

void dfs(int curR, int curC){
	int nextR, nextC;

	map[curR][curC]=0;
	cnt++;
	for (int i = 0; i < 4; i++){
		nextR = curR + dr[i];
		nextC = curC + dc[i];
		if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N && map[nextR][nextC]==1){
			dfs(nextR, nextC);
		}
	}
}

int main()
{
	int num[313], index = 0;

	scanf("%d", &N);
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++){
			scanf("%1d", &map[i][j]);
		}
	}

	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++){
			if (map[i][j]==1){
				dfs(i, j);
				num[index] = cnt;
				cnt = 0;
				index++;
			}
		}
	}
	sort(num, num + index);

	printf("%d\n",index);
	for (int i = 0; i < index; i++){
		printf("%d\n", num[i]);
	}

	return 0;
}