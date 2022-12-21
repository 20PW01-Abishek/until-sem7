#include <bits/stdc++.h>
using namespace std;
int coprime(int n)
{
    for(int i=n-2; i>0; i--)
        if(__gcd(i,n)==1)
            return i;
}
int main()
{
    int n;
    cout << "Enter n: ";
    cin >> n;
    cout << "greatest integer: "<<coprime(n);
    return 0;
}
