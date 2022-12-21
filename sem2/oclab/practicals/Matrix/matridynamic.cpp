#include <iostream>
using namespace std;
class Matrix
{
    int m;
    int *ptr;
    public:
        Matrix();
        Matrix(int b[], int n);
        void print();
};
Matrix::Matrix()
{
        ptr= new int [ptr[1]];
        ptr[0]=0;
}
Matrix::Matrix(int b[],int n)
{
    m=n;
    ptr = new int [n];
    for (int i=0; i<n; i++)
        ptr[i]=b[i];
}
void Matrix::print()
{
    for (int i=0; i<m; i++)
        cout << "\t" << ptr[i];
}
int main()
{
    int n;
    cin >> n;
    int a[n];
    for (int i=0; i<n; i++)
        cin >> a[i];
    Matrix obj(a,n);
    obj.print();
}
