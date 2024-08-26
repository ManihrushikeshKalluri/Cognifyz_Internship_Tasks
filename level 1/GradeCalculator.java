import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = scan.nextInt();

       
        double[] grades = new double[numberOfGrades];
        double sum = 0;

       
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scan.nextDouble();
            sum =  sum + grades[i];
        }

      
        double average = sum / numberOfGrades;

       
        System.out.println("The average grade is: " + average);

       
        scan.close();
    }
}

