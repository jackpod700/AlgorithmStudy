#include<iostream>
#include<string>
#include<vector>
#include<queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int N, K, W, top, next;
		vector<int> D(1005, 0);//각 건물의 건설시간
		vector<int> node[1005];//노드 별 이어지는 노드 
		vector<int> degree(1005, 0);//루트로부터 몇번째에 있는지
		vector<int> sum(1005, 0);//현재 노드까지의 총 건설 시간
		queue<int> q;

		cin >> N >> K;
		for (int j = 1; j <= N; j++) {
			cin >> D[j];
			sum[j] = D[j];
		}
		for (int j = 0; j < K; j++) {
			int x, y;
			cin >> x >> y;
			node[x].push_back(y);
			degree[y]++;
		}

		cin >> W;
		for (int j = 1; j <= N; j++) {
			if (!degree[j]) {//내 아래로 없으면
				q.push(j);//이 노드의 후행 노드들을 살펴보자
			}
		}
		while (!q.empty()) {
			top = q.front();
			q.pop();
			for (int j = 0; j < node[top].size(); j++) {
				next = node[top][j];
				if (sum[top] + D[next] > sum[next]) sum[next] = sum[top] + D[next];
				degree[next]--;
				if (!degree[next]) q.push(next);
			}
		}

		cout << sum[W]<<"\n";

	}
	return 0;
}