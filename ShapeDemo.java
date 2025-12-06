import java.util.Scanner;

// Abstract class
abstract class Shape {
    int dim1, dim2;

    // Method to be overridden
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        dim1 = length;
        dim2 = breadth;
    }

    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle = " + area);
    }
}

// Triangle class
class Triangle extends Shape {
    Triangle(int base, int height) {
        dim1 = base;
        dim2 = height;
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle = " + area);
    }
}

// Circle class
class Circle extends Shape {
    Circle(int radius) {
        dim1 = radius;
    }

    void printArea() {
        double area = 3.142 * dim1 * dim1;
        System.out.println("Area of Circle = " + area);
    }
}

// Driver class
public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rectangle length and breadth: ");
        Rectangle r = new Rectangle(sc.nextInt(), sc.nextInt());

        System.out.print("Enter Triangle base and height: ");
        Triangle t = new Triangle(sc.nextInt(), sc.nextInt());

        System.out.print("Enter Circle radius: ");
        Circle c = new Circle(sc.nextInt());

        r.printArea();
        t.printArea();
        c.printArea();
    }
}
