#include<bits/stdc++.h>
using namespace std;

string subStr(string s,int a,int b)
{
    string str="";
    for(int i=a-1;i<=b;i++)
    {
        str+=s[i];
    }
    return str;
}

int palindrome(string S, char C)
{
    if(S.length()==0)
        return 0;
    string p = "", str;
    int i,j,k,flag,maxLength = 1,start = 0;
    for (i = 0; i < S.length(); i++)
    {
        for (j = i; j < S.length(); j++)
        {
            flag = 1;
            for (k=0; k<(j-i+1)/2; k++)
            {
                if (S[i+k] != str[j-k])
                    flag = 0;
            }
            if (flag && (j-i+1) > maxLength)
            {
                start = i;
                maxLength = j-i+1;
            }
        }
    }
    cout<<subStr(S, start+1, start+maxLength);
    return maxLength;
}

int main()
{
    int T;
    cout << "No.of test cases: ";
    cin >> T;
    char C;
    string S;
    while(T--)
    {
        cout << "\nEnter char C: ";
        cin >> C;
        cout << "Enter string S: ";
        fflush(stdin);
        getline(cin,S);
        fflush(stdin);
        cout << "Max palindrome substr with char '" << C << "' is " << palindrome(S,C) << endl;
    }
    return 0;
}
