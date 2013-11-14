#include <bits/stdc++.h>
#define LL long long
#define MAXN 10005
#define eps 1e-8
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
using namespace std;
const int inf = 0x13131313;
int n, m;
int d[MAXN];
int cmp(int a, int b)
{
	return a<b;
}
bool check()
{
	if (m == 0) return true;
	if (d[0] == 1) return false;
	if (m >= 1 && d[m-1] == n) return false;
	for (int i = 1; i < m; i ++) {
		if (d[i] == d[i-1] + 1 && d[i] == d[i+1] - 1)  return false;
	}
	return true;
}
void work()
{
	for (int i = 0; i < m; i ++) {
		cin >> d[i];
	}
	sort(d,d+m,cmp);
	if (check()) printf("YES\n");
	else printf("NO\n");
}
int main()
{
	while (cin >> n >> m) {
		work();
	}
	return 0;
}