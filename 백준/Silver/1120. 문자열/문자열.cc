#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main()
{
	int answer=9999, cnt;
	string a, b;
	cin >> a >> b;
	
	for (int i = 0; i <= b.length()-a.length(); i++) {
		cnt = 0;
		for (int j = 0; j < a.length(); j++) {
			if (a[j] != b[i + j]) cnt++;
		}
		answer = min(answer, cnt);
	}
	cout << answer;
}