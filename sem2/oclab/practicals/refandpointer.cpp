#include <iostream>
using namespace std;
int main()
{
    int x = 10;
    int & refx = x;
    cout << "Size of x: " << sizeof(x) <<endl;
    cout << "Size of refx: " << sizeof(refx)<<endl;
    cout << "&x: " << &x<<endl;
    cout << "&refx: " << &refx<<endl;
}
