#include <iostream>
#include "set.h"
using namespace std;

int Set::add(int elt)
{
    set[sizeof(set)/sizeof(set[0])]=elt;
}

