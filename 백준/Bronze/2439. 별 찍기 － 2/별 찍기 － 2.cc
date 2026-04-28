#include<iostream>
#include <iomanip>
#include<algorithm>
using namespace std;

int main()
{
    int num;
    cin >> num;
    char* star = new char[num+1];
    fill_n(star, num+1, 0);

    cout.width(num);
    for (int i = 0; i < num; i++) {
        star[i] = '*';
        cout <<setw(num)<< star << endl;
    }
}