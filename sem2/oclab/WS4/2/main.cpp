#include <iostream>
#include "Set.h"
using namespace std;

int main()
{
    Set s1,s2,uni,inter;
    s1.add(3);
    s1.add(5);
    s1.add(4);
    s1.add(6);
    for (int i=0; i<4; i++)
        cout << s1.set[i] << ",";
    uni = s1 | s2;
    //inter = s1 & s2;
}
