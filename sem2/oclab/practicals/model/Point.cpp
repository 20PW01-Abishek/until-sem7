#include <iostream>
#include "point.h"
#include <cmath>
using namespace std;
Point::Point(float a, float b)
{
    this->x=a;
    this->y=b;
}
bool Point::isOrigin(Point p1)
{
    if(p1.x==0 && p1.y==0)
        return true;
    else
        return false;
    cout << endl;
}
