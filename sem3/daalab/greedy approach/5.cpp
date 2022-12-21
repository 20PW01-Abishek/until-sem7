#include <bits/stdc++.h>
using namespace std;
int activity(int s[],int f[],int n)
{
    int j=0, count=0;
    cout << "Activities: " << j;
    count++;
    for(int i=1; i<n; i++)
    {
        if(s[i]>=f[j])
        {
            count++;
            cout<< " " << i;
            j=i;
        }
    }
    cout << endl;
    return count;
}
int main()
{
    int n;
    cout << "Enter value for n: ";
    cin >> n;
    int start[n], finish[n];
    for(int i=0; i<n; i++)
        cin >> start[i];
    for(int i=0; i<n; i++)
        cin >> finish[i];
    cout << "Max activity: " << activity(start,finish,n);
    return 0;
}
