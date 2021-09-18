package stack_example;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        try {

            stack.insert(1);
            stack.insert(2);
            stack.insert(3);

            stack2.insert(4);
            stack2.insert(5);
            stack2.insert(6);

            stack.Alternate(stack2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
