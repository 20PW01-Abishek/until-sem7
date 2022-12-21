#include <iostream>
#include "add.h"
#include <string>
using namespace std;
int main()
{
    Address obj1,obj2(5);
    obj1.print();
    obj2.print();
    if (obj1.comes_before(obj2))
        cout << "Address comes before";
    else
        cout << "comes before";
}
