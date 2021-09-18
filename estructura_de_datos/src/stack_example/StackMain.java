package stack_example;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        try {

            stack.insert(1);
            stack.insert(2);
            stack.insert(3);

            System.out.println("Inserte tres nodos");
            stack.show();

            System.out.println("invertida");
            stack.inverse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
