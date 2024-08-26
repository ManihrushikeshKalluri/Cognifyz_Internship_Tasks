import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    
    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, 
                                          boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*-_=+|;:'\",.<>?/";

       
        String charPool = "";
        if (includeNumbers) {
            charPool += numbers;
        }
        if (includeLowercase) {
            charPool += lowercase;
        }
        if (includeUppercase) {
            charPool += uppercase;
        }
        if (includeSpecialChars) {
            charPool += specialChars;
        }

       
        if (charPool.isEmpty()) {
            return "Error: You must select at least one character type.";
        }

       
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

       
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
}

