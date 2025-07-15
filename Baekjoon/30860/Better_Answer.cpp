#include <iostream>
using namespace std;

int N;
int ans = 1, x, L, R;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	while (N--) {
		cin >> L >> R;
		if (x <= R) x = max(x, L);
		else ans++, x = L;
	}
	cout << ans;
}
