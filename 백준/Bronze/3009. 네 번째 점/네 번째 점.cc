#include<iostream>

using namespace std;

int main()
{
    int x, y, num1=0, num2=0, num3=0, num4=0;
    int xcount=0, ycount=0;
    cin >> num1 >> num2;
    xcount += num1;
    ycount += num2;

    for (int i = 0; i < 2; i++) {
        cin >> x >> y;
        if (x == num1) {
            num4 = y;
        }
        else if (y == num2) {
            num3 = x;
        }
        else {
            num3 = x;
            num4 = y;
        }

        xcount += x;
        ycount += y;
    }

    x = (num1 * 2) + (num3 * 2) - xcount;
    y = (num2 * 2) + (num4 * 2) - ycount;
    cout << x << " " << y << endl;
}