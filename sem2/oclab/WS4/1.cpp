#include <iostream>
using namespace std;
class Time
{
    int h;
    int m;
    int s;
    public:
        Time();
        Time(int h,int m,int s);
        Time operator +(Time);
        bool operator <(Time);
        void printTime();
};

Time::Time()
{

}

Time::Time(int h,int m,int s)
{
    this -> h = h;
    this -> m = m;
    this -> s = s;
}

Time Time::operator + (Time t)
{
    Time time;
    time.h = this -> h + t.h;
    time.m = this -> m + t.m;
    time.s = this -> s + t.s;
    if (time.s>=60)
    {
        time.s-=60;
        time.m+=1;
    }
    if (time.m>=60)
    {
        time.m-=60;
        time.h+=1;
    }
    return time;
}

void Time::printTime()
{
    cout << h << ":" << m << ":" << s << endl;
}

bool Time::operator < (Time t)
{
    if (h > t.h)
    {
        return true;
    }
    else if (h == t.h)
    {
        if (m > t.m)
        {
            return true;
        }
        else if (m == t.m)
        {
            if (s > t.s)
                return true;
            else
                return false;
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false;
    }
}

int main()
{
    Time obj1(4,52,24),obj2(3,54,12),obj3;
    cout << "Time1: ";
    obj1.printTime();
    cout << "Time2: ";
    obj2.printTime();
    obj3 = obj1 + obj2;
    cout << "Total time: ";
    obj3.printTime();
    int result = obj1 < obj2;
    cout << "Is T1 < T2: " << result << endl;
    result = obj1 < obj3;
    cout << "Is T1 < T3: " << result << endl;
    result = obj2 < obj1;
    cout << "Is T2 < T3: " << result << endl;
}
