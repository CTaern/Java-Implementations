public class TestCircle {

    public static void main(String[] args) {
        Circle circle = new Circle(5, new Point(10, 10));

        System.out.println("Circle area = " + circle.area() + " Circle perimeter = " + circle.perimeter());


        Circle circleA = new Circle(10, new Point(20, 20));

        boolean intersect = circle.intersect(circleA);

        if (intersect)
            System.out.println("Circles are intersecting");
        else
            System.out.println("Circles are not intersecting");
    }
}
