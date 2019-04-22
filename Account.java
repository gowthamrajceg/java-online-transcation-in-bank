import java.util.Scanner;
public abstract class Account {
	static String acc_name;
	static double acc_no;
	static double balance1;
	static double balance2;
	static float interest_rate;
	static int c1 = 1;
	static int c2 = 1;
	static int c3 = 1;
	public static void main(String[] args) {
System.out.println("welcome to my banking site -gowthamraj");
		Scanner s = new Scanner(System.in);
		String name;
		Double no,bl;
		boolean flag = true;
		int choice;
		CurrentAccount ca = new CurrentAccount();
		SavingsAccount sa = new SavingsAccount();
		LoanAccount la = new LoanAccount();
		System.out.print("Enter the Acc_Name : " );
		name = s.nextLine();
		System.out.print("Enter the Acc_Number : " );
		no = s.nextDouble();
		/*System.out.print("Enter the Balance Amount : " );
		bl = s.nextDouble();*/
		setName(name);
		setNo(no);
		//setBalance(bl);
		//System.out.print(getName());
		while(flag)
		{
			System.out.print("1.Display Account Details \n2.To See the Savings Balance\n3.To See the Current Savings\n4.To pay the Loan\n5.Exit..\nEnter Your Choice : ");
			choice = s.nextInt();
			switch(choice)
			{
			case 1:
			{
				tostring();
				break;
			}
			case 2:
			{
				sa.calculateInterestRate();
				break;
				
			}
			case 3:
			{
				ca.calculateInterestRate();
				break;
			}
			case 4:
			{
				la.calculateLoan();
				break;
			}
			case 5:
			{
				flag = false;
				break;
			}
			default:
			{
				System.out.println("Enter correct choice ...");
			}
		}
		}	
	}
	public static void setInterest(float interest)
	{
		interest_rate = interest;
	}
	public static void modInterest()
	{
		Scanner s = new Scanner(System.in);
		float interest;
		interest = s.nextFloat();
		interest_rate = interest;
	}
	public static float getInterest()
	{
		return interest_rate;
	}
	public static void setName(String name)
	{
		acc_name = name;
	}
	public static void setNo(double no)
	{
		acc_no = no;
	}
	public static void setBalance1(double bl)
	{
		balance1 = bl;
	}
	public static void setBalance2(double bl)
	{
		balance2 = bl;
	}
	public static String getName()
	{
		return acc_name;
	}
	public static double getNo()
	{
		return acc_no;
	}
	public static double getBalance1()
	{
		return balance1;
	}
	public static double getBalance2()
	{
		return balance2;
	}
	public static void tostring()
	{
		 System.out.println("Account Name : " + acc_name + "\nAccount Number : " + acc_no ); // I tried overriding toString() method but it's not working
	}
	public abstract double calculateInterestRate();
}
class SavingsAccount extends Account
{
	public double calculateInterestRate() {
		Scanner s = new Scanner(System.in);
		float ir;
		int c,m;
		double b;
		if(c1==1)
		{
			System.out.print("Enter the Savings Balance : ");
			b = s.nextDouble();
			setBalance1(b);
			c1++;
			System.out.printf("Savings Balance : %.2f \n",getBalance1());
		}
		else
		{
		System.out.print("Would to like to check the 1.Savings Balance(now) or 2.Time lapsed Month : ");
		c= s.nextInt();
		if(c == 1)
		{
			System.out.printf("Savings Balance : %.2f \n",getBalance1());
		}
		else
		{
			System.out.print("Enter the Interest Rate :");
			ir = s.nextFloat();
			setInterest(ir);
			System.out.print("Enter the number in months : ");
			m = s.nextInt();
			balance1 = balance1 + (balance1 * m * (ir/100));
			System.out.printf("Savings Balance : %.2f \n",getBalance1());
		}
		}
		return 0;
	}
}
class CurrentAccount extends Account
{
	
	public double calculateInterestRate() {
		Scanner s = new Scanner(System.in);
		float ir;
		int c,m;
		double b;
		if(c2==1)
		{
			System.out.print("Enter the Current Balance : ");
			b = s.nextDouble();
			setBalance2(b);
			c2++;
			System.out.printf("Current Balance : %.2f \n",getBalance2());
		}
		else
		{
		System.out.print("Would to like to check the 1.Current Savings(now) or 2.Time lapsed Month : ");
		c= s.nextInt();
		if(c == 1)
		{
			System.out.printf("Current Balance : %.2f \n",getBalance2());
		}
		else
		{
			System.out.print("Enter the Interest Rate :");
			ir = s.nextFloat();
			setInterest(ir);
			System.out.print("Enter the number in months : ");
			m = s.nextInt();
			balance2 = balance2 + (balance2 * m * (ir/100));
			System.out.printf("Current Balance : %.2f \n",getBalance2());
		}
		}
		return 0;
	}

}
class LoanAccount extends CurrentAccount
{
	static double total_loan ;
	static float loan_interest;
	public void calculateLoan()
	{
		Scanner s = new Scanner(System.in);
		int loan_period;
		double loan,loan_pay;
		int check;
		if(c3==1)
		{
		System.out.print("Enter the Total Loan Amount :");
		total_loan = s.nextDouble();
		System.out.print("The Total Loan Interest:");
		loan_interest = s.nextFloat();
		c3++;
		}
		System.out.print("Enter the Loan Period:");
		loan_period = s.nextInt();
		loan = (total_loan*loan_period*(loan_interest/100));
		System.out.printf("Loan Amount To be Paid : %.2f \n" , loan);
		System.out.print("Would like to pay the loan...1.Yes 2.No : ");
		check = s.nextInt();
		if(check==1)
		{
			System.out.print("Enter the Amount you are paying : ");
			loan_pay = s.nextDouble();
			balance2 = balance2 - loan_pay;
			total_loan = total_loan + loan - loan_pay;
			System.out.println("Loan Amount Paid : " + loan_pay);
			System.out.printf("Balance Loan Amount : %.2f \n", total_loan);
			System.out.printf("Current Balance : %.2f \n", getBalance2());
		}
		else
		{
			return;
		}
	}
}

