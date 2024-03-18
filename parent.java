import java.util.Scanner;

class Parent {
    public void print() {
        System.out.println("Parent's print method");
    }

    public void print(String message) {
        System.out.println("Parent's overloaded print method: " + message);
    }

    public void display() {
        System.out.println("Parent's display method");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child's display method");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message:");
        String message = scanner.nextLine();

        Parent parent = new Parent();
        parent.print();
        parent.print(message);
        parent.display();

        Child child = new Child();
        child.print();
        child.print(message);
        child.display();

        scanner.close();
    }
}
