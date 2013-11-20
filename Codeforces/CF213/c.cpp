#include <bits/stdc++.h>
#define LL long long
#define eps 1e-8
#define MAXN 4005
#define M1 50000
using namespace std;
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline void checkMax(T &a, T b) {if (a < b) a = b;}
template<typename T> inline void checkMin(T &a, T b) {if (a > b) a = b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;}
int a;
string s;
int num[MAXN];
int SumR[MAXN];
int Cnt[M1];
LL ans;
void work()
{
	cin >> s;
	int len = s.length();
	for (int i = 0; i < len; i ++) {
		num[i] = s[i] - '0';
	}
	for (int i = 0; i < len; i ++) {
		if (i == 0) SumR[i] = num[i];
		else SumR[i] = SumR[i-1] + num[i];
	}
	memset(Cnt,0,sizeof(Cnt));
	for (int i = 0; i < len; i ++) {
		for (int j = i; j < len; j ++) {
			int tmp = SumR[j];
			if (i != 0) tmp -= SumR[i-1];
			Cnt[tmp] ++;
 		}
	}
	ans = 0;
	for (int i = 0; i < len; i ++) {
		for (int j = i; j < len; j ++) {
			int tmp = SumR[j];
			if (i != 0) tmp -= SumR[i-1];
			if (tmp != 0) {
				if (a % tmp == 0) {
					//ans += Cnt[a / tmp];
					LL div = a / tmp;
					if (div <= SumR[len - 1]) {
						ans += Cnt[div];
					}
				}
			} else {
				if (a == 0) {
					ans += len * (len + 1) / 2;
				}
			}
		}
	}
	cout << ans << endl;
}
int main()
{
	while (cin >> a) {
		work();
	}
	return 0;
}