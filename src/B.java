public class B extends A {
    public B() {
        System.out.println("C");
    }

    public B(String h) {
        super();
        System.out.println("D");
    }
    public void say() {
        System.out.println("E");
    }
}