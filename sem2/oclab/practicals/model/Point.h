#ifndef POINT_H_INCLUDED
#define POINT_H_INCLUDED

class Point
{
    private:
        float x,y;
    public:
        bool isOrigin(Point p1);
        float distance(Point p1, Point p2);
        Point(float a, float b);
};

#endif // POINT_H_INCLUDED
