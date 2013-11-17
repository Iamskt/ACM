/*
 * tag: Math
 * 
 * so , this is a problem about bell equation
 * wo shou know some property about bell equation
 * bell[n+p] = (bell[n] + bell[n+1]) % p
 * while p is a prime number
 * so in this question 
 * wo can use Matrix quick pow algorithm and china remainder theorem
 * 
 * for this problem, wo should also know something. wo should find the number that give, it maybe have some use
 */
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>
#include <set>
#include <vector>
#include <list>
#include <deque>
#include <utility>
#include <queue>
#include <stack>
#include <cstdlib>
#include <ctime>
#define LL long long
#define eps 1e-8
#define MOD 95041567
#define MAXN 50
using namespace std;
template<typename T> inline T Max(T a, T b) {return a>b?a:b;}
template<typename T> inline T Min(T a, T b) {return a<b?a:b;}
template<typename T> inline T Abs(T a) {return a>0?a:-a;} 
template<typename T> inline T Swap(T &a, T &b) {T t=b;b=a;a=t;}
template<typename T> inline void checkMin(T &a, T b) {if(a>b) a=b;}
template<typename T> inline void checkMax(T &a, T b) {if(a<b) a=b;}
const int inf = 0x13131313;
LL n, t;
// 95041567 = 31 * 37 * 41 * 43 * 47
LL bell[MAXN];
LL cnk[MAXN][MAXN];
LL Pow[MAXN][MAXN];
void init()
{
	bell[0] = 1;
	for (int i = 0; i < MAXN; i ++) {
		for (int j = 0; j <= i; j ++) {
			if (j == 0 || j == i) cnk[i][j] = 1;
			else cnk[i][j] = (cnk[i-1][j-1] + cnk[i-1][j]) % MOD;
		}
	}
	for (int i = 0; i < MAXN-1; i ++) {
		LL tmp = 0;
		for (int j = 0; j <= i; j ++) {
			tmp = (tmp + cnk[i][j] * bell[j]) % MOD;
		}
		bell[i+1] = tmp;
	}
}
LL gcd(LL a, LL b) 
{
	if (b) return gcd(b, a%b);
	return a;
}
LL lcm(LL a, LL b)
{
	return a * b / gcd(a,b);
}
LL exgcd(LL a, LL b, LL &x, LL &y)
{
	if (b == 0) {
		x = 1;
		y = 0;
		return a;
	}
	LL d = exgcd(b, a%b, x, y), t = x;
	x = y;
	y = t - (a/b) * y;
	return d;
}
void MatrixPow(LL a[][MAXN], LL b[][MAXN], int n)
{
	LL c[MAXN][MAXN] = {};
	for (int i = 0; i < n; i ++) {
		for (int j = 0; j < n; j ++) {
			for (int k = 0; k < n; k ++) {
				c[i][j] += (a[i][k] * b[k][j]);
				c[i][j] %= n;
			}
		}
	}
	for (int i = 0; i < n; i ++) {
		for (int j = 0; j < n; j ++) {
			a[i][j] = c[i][j];
		}
	}
}
void construct(int n)
{
	memset(Pow,0,sizeof(Pow));
	Pow[0][n-1] = 1;
	for (int i = 1; i < n; i ++) {
		Pow[i][i] = Pow[i][i-1] = 1;
	}
}
int fun(int num)
{
	int cnt = n / (num - 1);
	int pos = n % (num - 1);
	construct(num);
	LL ans[MAXN][MAXN] = {};
	for (int i = 0; i < MAXN; i ++) ans[i][i] = 1;
	while (cnt) {
		if (cnt & 1) MatrixPow(ans,Pow,num);
		MatrixPow(Pow,Pow,num);
		cnt >>= 1;
	}
	LL data = 0;
	for (int i = 0; i < num; i ++) {
		data = data + ans[pos][i] * bell[i];
		data %= num;
	}
	return data;
}
LL _china_r(LL a1, LL m1, LL a2, LL m2)
{
	LL b1 = a2 % m2 - a1 % m1, k1, k2;
	exgcd(m1,m2,k1,k2);
	k1 = ((k1 * b1) % m2 + m2) % m2;
	return k1 * m1 + a1 % m1;
}
LL china(LL a[], LL m[], LL n)
{
	for (int i = 1; i < n; i ++) {
		a[i] = _china_r(a[i-1], m[i-1], a[i], m[i]);
		m[i] = lcm(m[i],m[i-1]);
	}
	return a[n-1];
}
void work()
{
	cin >> n;
	LL m[10] = {}, a[10] = {};
	m[0] = fun(31), a[0] = 31;
	m[1] = fun(37), a[1] = 37;
	m[2] = fun(41), a[2] = 41;
	m[3] = fun(43), a[3] = 43;
	m[4] = fun(47), a[4] = 47;
	LL ans = china(m,a,5);
	cout << ans << endl;
}
int main()
{
	init();
	cin >> t;
	while (t --) {
		work();
	}
	return 0;
}
