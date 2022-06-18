import java.util.Random;
import java.util.Scanner;
class Employee{
	static String F_Name;
	static String L_name;
	Employee(String First_Name,String Last_Name) {
		this.F_Name=First_Name;
		this.L_name=Last_Name;
	}
	
}

class Credential_Service extends Employee{
	Credential_Service(String First_Name, String Last_Name) {
		super(First_Name, Last_Name);
		// TODO Auto-generated constructor stub
	}
	public static String Genarate_password() {
		Random r=new Random();
		String specialCharacters = "!@#$";
		String d="";
		String temp="";
		int min=0;
		int max=9;
		for (int i=0;i<3;i++) {
		int c=(int) (Math.random()*(max-min+1)+min);
	    d=d+ Integer.toString(c);
		}
		d=d+specialCharacters.charAt(r.nextInt(specialCharacters.length()));
		for (int i=0;i<4;i++) {
			char e=(char) (r.nextInt(26)+'a');
			char f=(char)(r.nextInt(26)+'A');
			temp=temp+Character.toString(e);
			temp=temp+Character.toString(f);
		}
		for (int i=0;i<4;i++) {
			d=d+temp.charAt(r.nextInt(temp.length()));
		}
		return d;
	}
	public static String genarate_Email(int n) {
		String f=F_Name;
		String l=L_name;
		String res="";
		int k=n;
		switch(k) {
		case 1:
			res=f+l+"@"+"tech.abc.com";
			break;
		case 2:
			res=f+l+"@"+"adm.abc.com";
			break;
		case 3:
			res=f+l+"@"+"hmr.abc.com";
			break;
		case 4:
			res=f+l+"@"+"legal.abc.com";
		}
		
		return res;
	}
	public String ShowCrdentials(int n) {
		String show_mail,show_pass;
		show_mail=genarate_Email(n);
		show_pass=Genarate_password();
		String Show_Cred="Dear "+ F_Name+" your generated credentials are as follows\n \n"+
				 "Email"+"---->"+ show_mail +"\n"+ "Password "+"---->"+ show_pass;
		return Show_Cred;
	}
	
}

public class Emp {
	public static void main(String[] args) {
		
		Credential_Service obj1=new Credential_Service("Vamsi","matta");
		System.out.println("Please enter the department for the following :\n 1.Technical \n 2.Admin \n 3.Human Resource \n 4.Legal \n ");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		String res=obj1.genarate_Email(option);
		String show_res=obj1.ShowCrdentials(option);
		System.out.println(show_res);
		
		
		
		
	}

}
