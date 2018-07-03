import java.text.DecimalFormat;
import java.util.*;
public class Pay {

	public static void main(String[] args) {
		//declare necessary constant variables
		final int sl1PayRate = 17;
		final int sl2PayRate = 20;
		final int sl3PayRate = 22;
		final double medIns = 32.50;
		final double dentIns = 20;
		final double ltDisIns = 10;
		final double retPlan = .03;
		final int standardWeek = 40;
		
		//other variables
		int skillLevel;
		double hoursWorked;
		int hourlyRate = 0;
		double regPay = 0;
		double OT = 0;
		double grossPay = 0;
		int insurance;
		int retirement;
		double retFund;
		String deductions = "";
		double netPay = 0;
		
		//Decimal format
		DecimalFormat df = new DecimalFormat("###.##");
		
		//input scanner
		Scanner input = new Scanner(System.in);
		
		//display questions and get user input
		System.out.println("Enter your skill level ('1', '2', or '3'): ");
		skillLevel = input.nextInt();
		System.out.println("How many hours did you work this week? ");
		hoursWorked = input.nextDouble();
		
		//calculation
		if(skillLevel == 1) {
			hourlyRate = sl1PayRate;
			if(hoursWorked > standardWeek) {
				regPay = 40 * sl1PayRate;
				OT = (hoursWorked - standardWeek) * sl1PayRate * 1.5;
				grossPay = OT + regPay;
			} else {
				regPay = hoursWorked * sl1PayRate;
				OT = 0;
				grossPay = OT + regPay;
			}
			//default values for no selected/available options
			netPay = grossPay;
			deductions = "Medical Insurance: $0\nDental Insurance: $0\nLong-Term Disability Insurance: $0\nRetirement Plan: $0";
		} else if(skillLevel == 2) {
			hourlyRate = sl2PayRate;
			if(hoursWorked > standardWeek) {
				regPay = 40 * sl2PayRate;
				OT = (hoursWorked - standardWeek) * sl2PayRate * 1.5;
				grossPay = OT + regPay;
			} else {
				regPay = hoursWorked * sl2PayRate;
				OT = 0;
				grossPay = OT + regPay;
			}
			//insurance option election
			System.out.println("Would you like one of the following insurance options?\nMedical Insurance: $32.50 per week (Enter '1')\nDental Insurance: $20.00 per week (Enter '2')\nLong-Term Disability Insurance: $10.00 per week (Enter '3')");
			insurance = input.nextInt();
			
			//calculate deductions
			if(insurance == 1) {
				netPay = grossPay - medIns;
				deductions = "Medical Insurance: $32.50\nDental Insurance: $0\nLong-Term Disability Insurance: $0\nRetirement Plan: $0";
			} else if(insurance == 2) {
				netPay = grossPay - dentIns;
				deductions = "Medical Insurance: $0\nDental Insurance: $20.00\nLong-Term Disability Insurance: $0\nRetirement Plan: $0";
			} else if(insurance == 3) {
				netPay = grossPay - ltDisIns;
				deductions = "Medical Insurance: $0\nDental Insurance: $0\nLong-Term Disability Insurance: $10.00\nRetirement Plan: $0";
			} else {
				System.out.println("Please enter an appropriate value!");
				return;
			}
		} else if(skillLevel == 3) {
			hourlyRate = sl3PayRate;
			if(hoursWorked > standardWeek) {
				regPay = 40 * sl3PayRate;
				OT = (hoursWorked - standardWeek) * sl3PayRate * 1.5;
				grossPay = OT + regPay;
			} else {
				regPay = hoursWorked * sl3PayRate;
				OT = 0;
				grossPay = OT + regPay;
			}
			//insurance option election
			System.out.println("Would you like one of the following insurance options?\nMedical Insurance: $32.50 per week (Enter '1')\nDental Insurance: $20.00 per week (Enter '2')\nLong-Term Disability Insurance: $10.00 per week (Enter '3')");
			insurance = input.nextInt();
			
			//calculate deductions
			if(insurance == 1) {
				netPay = grossPay - medIns;
				deductions = "Medical Insurance: $32.50\nDental Insurance: $0\nLong-Term Disability Insurance: $0\n";
			} else if(insurance == 2) {
				netPay = grossPay - dentIns;
				deductions = "Medical Insurance: $0\nDental Insurance: $20.00\nLong-Term Disability Insurance: $0\n";
			} else if(insurance == 3) {
				netPay = grossPay - ltDisIns;
				deductions = "Medical Insurance: $0\nDental Insurance: $0\nLong-Term Disability Insurance: $10.00\n";
			} else {
				System.out.println("Please enter an appropriate value!");
				return;
			}
			
			//retirement plan option
			System.out.println("Would you like to participate in our Retirement Plan at 3% of your gross pay? (Enter '1' for yes and '2' for no)");
			retirement = input.nextInt();
			
			//calculate retirement deductions
			if(retirement == 1) {
				retFund = grossPay * retPlan;
				netPay -= retFund;
				deductions += "Retirement Plan: $" + df.format(retFund);
			} else {
				deductions += "Retirement Plan: $0";
			}
		} else {
			System.out.println("Please enter an appropriate value!");
			return;
		}
		
		//if net pay < 0 throw error
		if(netPay < 0) {
			System.out.println("There's been an error in your pay calculation. Benefits/Deductions more than gross pay.");
		} else {
			System.out.println("Hours worked: " + hoursWorked + "\nHourly Rate: " + hourlyRate + "\nRegular Pay: $" + regPay + "\nOverTime Pay: $" + OT + "\nGross Pay: $" + grossPay + "\n" + deductions + "\nNet Pay: $" + netPay);
		}
	}
	
}
