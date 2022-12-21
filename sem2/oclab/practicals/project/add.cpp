#include <iostream>
#include "add.h"
#include <string>
using namespace std;

Address::Address ()
{
    house_no=52;
    street="Rams Nagar";
    city="Coimbatore";
    state="Tamil Nadu";
    postal=624009;
}
Address::Address (int appt_no)
{
    this -> appt_no = appt_no;
    house_no=27;
    street="Smar Nagar";
    city="Coimbatore";
    state="Tamil Nadu";
    postal=624983;
}
void Address::print()
{
    cout << house_no << "," << street << "," << endl;
    cout << city << "," << state << "," << postal << "." << endl << endl;
}
bool Address::comes_before(Address a2)
{
    if ( this -> postal - a2.postal < 0 )
        return true;
    else
        return false;
}
