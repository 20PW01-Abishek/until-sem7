#include<bits/stdc++.h>
using namespace std;
int max_index(int a[2][5], int r, int c)
{
    int maxind=0;
    int curr_col=c-1;
    for(int i=0;i<r;i++)
    {
        while(curr_col>=0 && a[i][curr_col]==1)
        {
            curr_col=curr_col-1;
            maxind=i;
        }
    }
    return maxind+1;
}
int main()
{
    int a[2][5]={{1,0,0,0,0},{0,0,0,1,1}};
    cout<<"Max index: "<<max_index(a,2,5);
    return 0;
}
