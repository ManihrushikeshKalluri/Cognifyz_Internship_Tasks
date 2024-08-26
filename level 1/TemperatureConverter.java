import java.util.Scanner;
public class TemperatureConverter{
	
	public static void main (String[ ] args){
		
		Scanner scan = new  Scanner(System.in);
		System.out.println("fahrenheit to celsius(1) or celsius to fahrenheit(2)");
		int result=scan.nextInt();
		
		if (result==1){
			System.out.println("you have choosed for fahrenheit to celsius");
			System.out.println("enter a fahrenheit value:");
			double value = scan.nextDouble();
			double ValueFinal=(value - 32)*5/9;
			System.out.print("celsius is:");
			System.out.println(Math.round(ValueFinal*10.0)/10.0);
			}
			
		else if (result==2){
			     System.out.println("you have choosed for celsius to fahrenheit");
			     System.out.println("enter a celsius value: ");
			    double value2 = scan.nextDouble();
			    double FinalValue=(value2 *(9/5) )+ 32;
			    System.out.print("fahrenheit is:");
			    System.out.println(Math.round(FinalValue*10.0)/10.0);
			}
			
		else {
			System.out.println("not a valid choice!!!!!");
		}
	
	}
}
