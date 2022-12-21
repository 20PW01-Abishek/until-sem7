#ifndef ADDRESS_H_INCLUDED
#define ADDRESS_H_INCLUDED
#include <string>
using namespace std;
class Address
{
    int house_no;
    string street;
    int appt_no;
    string city;
    string state;
    int postal;
    public:
        Address ();
        Address (int);
        void print();
        bool comes_before(Address);
};

#endif // ADDRESS_H_INCLUDED
