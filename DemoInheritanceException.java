import java.util.Scanner;

// Custom Exception for invalid father age
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Custom Exception for invalid son age
class SonAgeException extends Exception {
    public SonAgeException(String message) {
        super(message);
    }
}

// Base Class
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        fatherAge = age;
    }
}

// Derived Class
class Son extends Father {
    int sonAge;

    Son(int fAge, int sAge) throws WrongAge, SonAgeException {
        super(fAge); // validate father age

        if (sAge >= fAge) {
            throw new SonAgeException("Son's age cannot be >= Father's age!");
        }
        if (sAge < 0) {
            throw new SonAgeException("Son's age cannot be negative!");
        }

        sonAge = sAge;
    }
}

// Driver Class
public class DemoInheritanceException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Father's age: ");
            int fatherAge = sc.nextInt();

            System.out.print("Enter Son's age: ");
            int sonAge = sc.nextInt();

            Son obj = new Son(fatherAge, sonAge);

            System.out.println("\nVALID DATA:");
            System.out.println("Father Age : " + obj.fatherAge);
            System.out.println("Son Age    : " + obj.sonAge);

        } catch (WrongAge e) {
            System.out.println("WrongAge Exception: " + e.getMessage());

        } catch (SonAgeException e) {
            System.out.println("SonAgeException: " + e.getMessage());
        }

        sc.close();
    }
}
