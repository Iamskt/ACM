/*
 * Graph 
 * construct a reverse graph, do a dijkstra
 * don't do a forward graph and do it for many time, and it is not a useful algorithm
 */
#include <bits/stdc++.h>
#define MAXN 50
using namespace std;
const int inf = 0x13131313;
template<typename T> inline T Swap(T &a, T &b) {T t = b; b = a; a = t;}
int t, n, f, Mat[MAXN][MAXN], lowcost[MAXN];
int src, cnt, num[MAXN], re[MAXN];
bool vis[MAXN];
string line;
struct node
{
	int org, dest, times;
	vector<int> path;
	void init(int org, int dest) {
		this->times = 0;
		this->org = org, this->dest = dest;
		this->path.clear();
	}
	void print() {
		cout << org << "\t" << dest << "\t" << times;
		for (int i = 0; i < path.size(); i ++) {
			cout << "\t" << path[i];
		}
		cout << endl;
	}
	bool operator < (const node &tmp) const {
		return times < tmp.times;
	}
};
void deal()
{
	cnt = 0;
	int tmp = 0;
	for (int i = 0; i < line.length(); i ++) {
		if (line[i] >= '0' && line[i] <= '9') {
			tmp = tmp * 10 + line[i] - '0';
		} else {
			if (tmp) {
				num[cnt ++] = tmp;
				tmp = 0;
			}
		}
	}
	if (tmp) num[cnt ++] = tmp;
	src = num[0];
}
void dijkstra()
{
	memset(vis,false,sizeof(vis));
	memset(re,0,sizeof(re));
	memset(lowcost,inf,sizeof(lowcost));
	queue<int> que;
	que.push(src);
	vis[src] = true;
	lowcost[src] = 0;
	while (!que.empty()) {
		int now = que.front();
		for (int i = 1; i <= n; i ++) {
			if (!vis[i] && Mat[now][i] >= 0 && lowcost[i] > lowcost[now] + Mat[now][i]) {
				lowcost[i] = lowcost[now] + Mat[now][i];
				re[i] = now;
			}
		}
		int MinAns = inf, index = 0;
		for (int i = 1; i <= n; i ++) {
			if (!vis[i] && MinAns > lowcost[i]) {
				MinAns = lowcost[i];
				index = i;
			}
		}
		if (index) {
			que.push(index);
			vis[index] = true;
		} else {
			break;
		}
		que.pop();
	}
}
void getpath(node &tmp)
{
	int d = tmp.dest;
	while (d != tmp.org) {
		tmp.path.push_back(d);
		d = re[d];
	}
	tmp.path.push_back(tmp.org);
}
void work()
{
	scanf("%d",&n);
	for (int i = 1; i <= n; i ++) {
		for (int j = 1; j <= n; j ++) {
			scanf("%d",&Mat[i][j]);
		}
	}
	for (int i = 1; i <= n; i ++) {
		for (int j = i; j <= n; j ++) {
			Swap(Mat[i][j], Mat[j][i]);
 		}
	}
	getchar();
	getline(cin,line);
	deal();
	vector <node> vec;
	vec.clear();
	printf("Org\tDest\tTime\tPath\n");
	dijkstra();
	for (int i = 1; i < cnt; i ++) {
		node tmp;
		tmp.init(num[i], src);
		tmp.times = lowcost[num[i]];
		int d = num[i];
		while (d != src) {
			tmp.path.push_back(d);
			d = re[d];
		}
		tmp.path.push_back(src);
		vec.push_back(tmp);
	}
	sort(vec.begin(), vec.end());
	for (int i = 0; i < vec.size(); i ++) {
		vec[i].print();
	}
}
int main()
{
	scanf("%d",&t);
	while (t --) {
		work();
		if (t) printf("\n");
	}
	return 0;
}