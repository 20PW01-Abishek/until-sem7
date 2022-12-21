int main()
{
        Stack S;
        int n;
        cout << "Enter a number" << endl << "1 to push" << endl << "2 to pop" << endl << "3 to check if stack is empty" << endl;
        cout << "4 to check if stack is full" << endl << "5 to display top" << endl << "6 to display top elt" << endl;
        cin >> n;
        if (n==1)
        {
                cout << "Enter a number" << endl;
                int elt;
                cin >> elt;
                S.push(elt);
        }
        else if(n==2)
                S.pop();
        else if (n==3)
                S.isstackempty();
        else if (n==4)
                S.isstackfull();
        else if (n==5)
                S.displaytop();
        else  if (n==6)

