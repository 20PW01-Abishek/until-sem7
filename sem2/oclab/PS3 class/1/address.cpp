#include <iostream>
#include "address.h"
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
    cout << house_no2 << "," << street << "," << endl;
    cout << city << "," << state << "," << postal << "." << endl;
}
void Address::comes_before()
{

}
