#include <iostream>
#include "Point.h"
using namespace std;

int main()
{
    float x1,y1,x2,y2;
    cout << "Enter x1: ";
    cin >> x1;
    cout << "Enter y1: ";
    cin >> y1;
    cout << "Enter x2: ";
    cin >> x2;
    cout << "Enter y2: ";
    cin >> y2;

    Point p1(x1,y1), p2(x2,y2);
    cout<<"p1: " <<p1.isOrigin(p1) << endl;
    cout<<"p2: " <<p2.isOrigin(p2);
}
