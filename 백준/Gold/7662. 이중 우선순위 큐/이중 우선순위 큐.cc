#include <cstdio>
#include <queue>

using namespace std;

#define MAXN 1000006
typedef long long lld;
typedef pair<lld,int> pli;

int T,K,Q;
bool out[MAXN];
priority_queue <pli> mx,mn;

int main()
{
	lld v;
	char ch;
	for (scanf("%d",&T);T--;){
		K = 0;
		mx = priority_queue <pli> ();
		mn = priority_queue <pli> ();
		for (scanf("%d",&Q);Q--;){
			scanf(" %c%lld",&ch,&v);
			if (ch == 'I'){
				out[++K] = 0;
				mx.push(pli(v,K));
				mn.push(pli(-v,K));
			}
			else{
				while (!mx.empty() && out[mx.top().second]) mx.pop();
				while (!mn.empty() && out[mn.top().second]) mn.pop();
				if (mx.empty()) continue;
				if (v > 0){
					out[mx.top().second] = 1;
					mx.pop();
				}else{
					out[mn.top().second] = 1;
					mn.pop();
				}
			}
		}
		while (!mx.empty() && out[mx.top().second]) mx.pop();
		while (!mn.empty() && out[mn.top().second]) mn.pop();
		if (mx.empty()){ puts("EMPTY"); continue; }
		printf("%lld ",mx.top().first);
		printf("%lld\n",-mn.top().first);
	}
}