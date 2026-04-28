#include<iostream>

using namespace std;

int main()
{
	int x, y, days;
	char week[7][4] = { "MON", "TUE", "WED", "THU", "FRI", "SAT","SUN" };
	cin >> x >> y;
	if (x <= 7) {
		if (x > 2) {
			days = (x - 1) * 31 + (y - 1) - ((x-1)/2+2);
		}
		else {
			days = (x - 1) * 31 + (y - 1);
		}
	}
	else {
		days = 211;
		if (x > 11) days += (x - 8) * 31 + y - 2;
		else if (x > 9) days += (x - 8) * 31 + y - 1;
		else days += (x - 8) * 31 + y;
	}
	
	cout << week[days % 7];
}