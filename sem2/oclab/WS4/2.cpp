#include <iostream>
using namespace std;
class Set
{
    int *a,n;
    public:
        int add(int);
        void display();
        void remove(int);
        Set operator | (Set &);
        Set operator & (Set &);
};

void Set::remove(int x)
{
    for(int i=0; i<n; i++)
    {
        if(a[i]==x)
        {
            for(int j=i; j<n; j++)
                a[j]=a[j+1];
            a[--n];
        }
    }
}

int Set::add(int n)
{
    this -> n=n;
    a = new int[n];
    for(int i=0; i<n; i++)
    {
        cout << "Enter element: ";
        cin >> a[i];
    }
}

Set Set::operator | (Set &a)
{
    for(int i=0; i<n ;i++)
    {

    }
}

Set Set::operator & (Set &a)
{

}

void Set::display()
{
    cout << endl;
    for(int i=0; i<n; i++)
        cout << a[i] << ", ";
    cout << endl;
}

int main()
{
    Set s1,s2,u;
    s1.add(5);
    s1.display();
    s2.add(4);
    s2.display();
    //inter = s1 & s2;
    s1.remove(3);
    s1.display();
    u = s1 | s2;
    u.display();
}
