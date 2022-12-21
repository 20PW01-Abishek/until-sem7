#ifndef SET_H_INCLUDED
#define SET_H_INCLUDED
#include <iostream>

class Set
{
    public:
        int set[100];
        int add(int);
        void remove(int);
        Set operator | (Set &);
        Set operator & (Set &);
};

#endif // SET_H_INCLUDED
