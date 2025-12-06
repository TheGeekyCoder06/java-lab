class Counter {
    static int count = 0;   // static variable

    Counter() {
        count++;            // increment when object is created
    }
}

public class CounterDemo {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        System.out.println("Number of objects created = " + Counter.count);
    }
}
