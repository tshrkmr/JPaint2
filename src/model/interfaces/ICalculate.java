package model.interfaces;

import model.persistence.Point;

public interface ICalculate {

    void Calculate(Point starPoint, Point endPoint);
    boolean isOverlapping(int x, int y, int width, int height);
//    int getSelectX();
//    int getSelectY();
//    int getSelectWidth();
//    int getSelectHeight();
}
