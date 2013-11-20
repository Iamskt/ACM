#include <bits/stdc++.h>
#define LL long long
#define eps 1e-8
#define MAXN 100005
using namespace std;
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline void checkMax(T &a, T b) {if (a < b) a = b;}
template<typename T> inline void checkMin(T &a, T b) {if (a > b) a = b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
int n;
LL a[MAXN];
void work()
{
	for (int i = 0; i < n; i ++) {
		cin >> a[i];
	}
	int ans = 0;
	int lastAns = 0;
	for (int i = 0; i < n; i ++) {
		if (ans == 0) ans ++;
		else if (ans == 1) ans ++;
		else {
			if (a[i] == a[i-1] + a[i-2]) {
				ans ++;
			} else {
				ans = 2;
			}
		}
		checkMax(lastAns,ans);
	}
	cout << lastAns << endl;
}
int main()
{
	while (cin >> n) {
		work();
	}
	return 0;
}