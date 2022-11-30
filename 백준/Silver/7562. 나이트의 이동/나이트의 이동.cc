#include <cstdio>
#include <queue>

using namespace std;

int main()
{
	int T;

	scanf("%d", &T);
	while (T--)
	{	
		queue<int> XQ;
		queue<int> YQ;
		int l;
		int x, y;
		int des_x, des_y;
		scanf("%d", &l);
		scanf("%d %d", &x, &y);
		scanf("%d %d", &des_x, &des_y);
		int ChessTable[300][300] = { 0, };
		ChessTable[x][y] = 0;
		if (x == des_x && y == des_y)
		{
			printf("0\n");
			continue;
		}
		XQ.push(x);
		YQ.push(y);
		while (ChessTable[des_x][des_y] == 0)
		{
			int now_x, now_y, next_x, next_y;
			now_x = XQ.front();
			now_y = YQ.front();
			XQ.pop();
			YQ.pop();

			next_x = now_x + 1;
			next_y = now_y + 2;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x + 2;
			next_y = now_y + 1;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x + 1;
			next_y = now_y - 2;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x + 2;
			next_y = now_y - 1;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x - 1;
			next_y = now_y + 2;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x - 2;
			next_y = now_y + 1;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x - 2;
			next_y = now_y - 1;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
			next_x = now_x - 1;
			next_y = now_y - 2;
			if (next_x >= 0 && next_y >= 0 && next_x < l&&next_y < l)
			{
				if (ChessTable[next_x][next_y] == 0)
				{
					ChessTable[next_x][next_y] = ChessTable[now_x][now_y] + 1;
					XQ.push(next_x);
					YQ.push(next_y);
				}
			}
		}
		printf("%d\n", ChessTable[des_x][des_y]);
	}

	return 0;
}