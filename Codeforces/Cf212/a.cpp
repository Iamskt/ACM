#include <bits/stdc++.h>
#define LL long long
#define MAXN 10
#define eps 1e-8
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
using namespace std;
const int inf = 0x13131313;
int t;
string line;
int Map[MAXN][MAXN];
int value[MAXN][MAXN][2];
int dir[4][2] = {{2,2},{2,-2},{-2,2},{-2,-2}};
struct point
{
	int x,y;
	int len;
}q[2];
void bfs(int index)
{
	q[index].len = 0;
	bool vis[MAXN][MAXN] = {};
	queue<point> que;
	que.push(q[index]);
	vis[q[index].x][q[index].y] = true;
	value[q[index].x][q[index].y][index] = q[index].len;
	while (!que.empty()) {
		int newx, newy;
		point now = que.front();
		for (int i = 0; i < 4; i ++) {
			newx = now.x + dir[i][0];
			newy = now.y + dir[i][1];
			if (newx >= 1 && newx <= 8 && newy >= 1 && newy <= 8 && !vis[newx][newy]) {
				vis[newx][newy] = true;
				point next;
				next.x = newx, next.y = newy;
				next.len = now.len + 1;
				value[next.x][next.y][index] = next.len;
				que.push(next);
			}
		}
		que.pop();
	}
}
bool check()
{
	for (int i = 1; i <= 8; i ++) {
		for (int j = 1; j <= 8; j ++) {
			if (Map[i][j] == 2) continue;
			if (value[i][j][0] > 100000 || value[i][j][1] > 100000) continue;
			int sub = value[i][j][0] - value[i][j][1];
			if (sub % 2 == 0) {
				return true;
			}
		}
	}
	return false;
}
void work()
{
	memset(Map,0,sizeof(Map));
	memset(value,inf,sizeof(value));
	int index = 0;
	for (int i = 1; i <= 8; i ++) {
		cin >> line;
		for (int j = 0; j < 8; j ++) {
			if (line[j] == '.') Map[i][j+1] = 1;
			else if (line[j] == '#') Map[i][j+1] = 2;
			else {
				Map[i][j+1] = 3;
				q[index].x = i, q[index].y = j+1;
				index ++;
			}
		}
	}
	bfs(0);
	bfs(1);
	if (check()) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
}
int main()
{
	scanf("%d",&t);
	while (t --) {
		work();
	}
	return 0;
}