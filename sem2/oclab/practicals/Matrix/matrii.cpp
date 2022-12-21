#include <iostream>
using namespace std;
class Matrix
{
    int a[3];
    public:
        Matrix();
        Matrix(int a[]);
        void print();
};
Matrix::Matrix()
{
    for (int i=0; i<3 ;i++)
        a[i]=0;
}
Matrix::Matrix(int b[3])
{
    for (int i=0; i<3; i++)
        a[i]=b[i];
}
void Matrix::print()
{
    for (int i=0; i<3; i++)
        cout << "\t" << a[i];
}
int main()
{
    int a[3]={1,2,3};
    Matrix obj(a);
    obj.print();
}
