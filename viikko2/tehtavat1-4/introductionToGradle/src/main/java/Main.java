import java.util.Scanner;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Multiplier three = new Multiplier(3);
        System.out.println("Give a number?");
        int number = scanner.nextInt();

        System.out.println("3 multiplied by " + number + " is equal to " + three.multipliedBy(number));
    }
}