
 import java.util.Scanner;

class PasswordStrengthChecker1 {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter your password: ");

        
        String password = scanner.nextLine();

        
        System.out.println("Your password is: " + password);

       
        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);

       
        scanner.close();
    }

    
    public static String checkPasswordStrength(String password) {
        int lengthCriteria = password.length() >= 8 ? 1 : 0;
        int upperCaseCriteria = containsUpperCase(password) ? 1 : 0;
        int lowerCaseCriteria = containsLowerCase(password) ? 1 : 0;
        int digitCriteria = containsDigit(password) ? 1 : 0;
        int specialCharCriteria = containsSpecialChar(password) ? 1 : 0;

        int score = lengthCriteria + upperCaseCriteria + lowerCaseCriteria + digitCriteria + specialCharCriteria;

        if (score == 5) {
            return "Strong";
        } else if (score >= 3) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    
    private static boolean containsUpperCase(String str) {
        return str.matches(".*[A-Z].*");
    }

    private static boolean containsLowerCase(String str) {
        return str.matches(".*[a-z].*");
    }

    private static boolean containsDigit(String str) {
        return str.matches(".*\\d.*");
    }

    private static boolean containsSpecialChar(String str) {
        return str.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}


