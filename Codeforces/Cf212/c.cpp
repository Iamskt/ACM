#include <bits/stdc++.h>
#define LL long long
#define MAXN 5005
#define eps 1e-8
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
using namespace std;
const int inf = 0x13131313;
int n;
int a[MAXN];
int ans, MinAns, Cnt;
int rail[MAXN][MAXN];
int top[MAXN][MAXN];
void work()
{
	for (int i = 1; i <= n; i ++) {
		cin >> a[i];
	}
	ans = MinAns = Cnt = 0;
	for (int i = 1; i <= n; i ++) {
		for (int j = i+1; j <= n; j ++) {
			if (a[j] < a[i]) Cnt ++;
		}
	}
	for (int i = 1; i <= n; i ++) {
		for (int j = n+1; j >= 1; j --) {
			if (j == n+1) {
				rail[i][j] = 0;
				continue;
			}
			rail[i][j] = rail[i][j+1];
			if (a[j] < a[i]) rail[i][j] ++;
		}
	}
	for (int i = 1; i <= n; i ++) {
		for (int j = i+1; j <= n; j ++) {
			int now = 0;
			now = rail[i][j+1] + rail[j][i+1] - rail[i][i+1] - rail[j][j+1];
			int len = j-i-1;
			now -= len - (rail[j][i+1] - rail[j][j+1]);
			now += len - (rail[i][i+1] - rail[i][j+1]);
			now ++;
			if (now < MinAns) {
				MinAns = now;
				ans = 1;
			} else if (now == MinAns) {
				ans ++;
			}
		}
	}
	cout << Cnt + MinAns << " " << ans << endl;
}
int main()
{
	while (cin >> n) {
		work();
	}
	return 0;
}