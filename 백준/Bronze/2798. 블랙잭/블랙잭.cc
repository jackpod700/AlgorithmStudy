#include<iostream>
#include<algorithm>

using namespace std;

int main()
{
	int n, m, answer=0, temp;
	cin >> n >> m;
	int* numbers = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> numbers[i];
	}

	for (int i = 0; i < n - 2; i++) {
		for (int j = i + 1; j < n - 1; j++) {
			for (int k = j + 1; k < n; k++) {
				temp = numbers[i] + numbers[j] + numbers[k];
				if (temp <= m) answer = max(temp, answer);
			}
		}
	}

	cout << answer;
}