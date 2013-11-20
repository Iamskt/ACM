#include <bits/stdc++.h>
#define LL long long
#define eps 1e-8
#define MAXN 105
using namespace std;
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline void checkMax(T &a, T b) {if (a < b) a = b;}
template<typename T> inline void checkMin(T &a, T b) {if (a > b) a = b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
const int inf = 0x13131313;
int n,k;
int ans;
string a[MAXN];
bool vis[10];
bool check()
{
	for (int i = 0; i < 10; i ++) {
		if (i <= k) {
			if (!vis[i]) return false;
		}
	}
	return true;
}
void work()
{
	ans = 0;
	for (int i = 0; i < n; i ++) {
		cin >> a[i];
		memset(vis,false,sizeof(vis));
		for (int j = 0; j < a[i].length(); j ++) {
			vis[a[i][j] - '0'] = true;
		}
		if (check()) ans ++;
	}
	cout << ans << endl;

}
int main()
{
	while (cin >> n >> k) {
		work();
	}
	return 0;
}