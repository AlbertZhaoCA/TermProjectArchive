package finalProject;

import java.util.ArrayList;

public class InternetServer {
	/**
	 * userInformation store the id and code for verification
	 * the ID and code is stored as: ID&Code likes：123&abc123
	 * this data field must be initialized in the constructor
	 * and only allow corresponding user changing their code  
	 *
	 * connectedTerminal is the terminal that connected to the server,
	 * 
	 */
	private String[] allowedUserInformation;
	private ArrayList<Object> connctedTerminal = new ArrayList<>();
	
	//Constructor
	public InternetServer(String[] userInformation) {
		this.allowedUserInformation = userInformation;
	}
	
	//getter 
	public ArrayList<Object>  getConnectedTerminal() {
		return this.connctedTerminal;
	}
	
	public String[] getAllowedUserInformation() {
		return this.allowedUserInformation;	
	}
	
	//Signature:public void addTerminal(Object o, String id,String code)
	//Purpose: to add a Terminal to retrieve data stored in the server
	//if no corresponding id and code in the userInformation, we will not
	//the user to add this terminal
	//
	//Example: public void addTerminal(Student, 12345 , 12345);
	// we find the corresponding id 12345 and code 12345 
	// then this terminal is added to connctedTerminal.
	// 
	public void addTerminal(Object o, String id,String code) {
		boolean matched = false;
		for(int i = 0;i<allowedUserInformation.length;i++) {
			//test whether the id and code is in the userInformation
				if(id.equals(allowedUserInformation[i].substring(0,allowedUserInformation[i].indexOf('&')))
						&&code.equals(allowedUserInformation[i].substring(allowedUserInformation[i].indexOf('&')+1))) 			
				matched = true;
		}
		
				while(matched) {
				connctedTerminal.add(o);
				System.out.println("Please remember your key index " +connctedTerminal.indexOf(o)+"\n"
						+ "when you are using other Terminal, you can use this index to find the necessary information ");
				break;
				}
				while(!matched) {
				System.out.println("You are not allowed to use this serivice\n"
						+ "Please find IT support for more information");
				break;
				}
	}
	
	//Signature:public boolean verification(Object verifying)
	//Purpose: to find whether verifying object is connected to the server
	//Example:verification(o)return false if o is connected to the server
	public boolean verification(Object verifying) {
		return connctedTerminal.contains(verifying);
	}
	
	//Signature:public void changeCode(String id,String code) 
	//Purpose: to change the current user code
	//Example:changeCode("123","321") if user 123 exits then code becomes 321
	//otherwise show You are not allowed to use this service
	public void changeCode(String id,String code) {
		boolean matched = false;
		int userIndex = 0;
		for(int i = 0;i<allowedUserInformation.length;i++) {
			//test whether the id and code is in the userInformation
				if(id.equals(allowedUserInformation[i].substring(0,allowedUserInformation[i].indexOf('&')))) 			
				matched = true;
				userIndex = i;
		}
		
				while(matched) {
					allowedUserInformation[userIndex]=id+"&"+code;
					System.out.println("Please REMEMBER your new code "+ "user "+ id + "\nCODE:"+code);
					break;
							
				}
				while(!matched) {
					System.out.println("You are not allowed to use this serivice\n"
							+ "Please find IT support for more information");
					break;
				}
	}
	//Signature:public void onlinePaymentInterface(Object payer,double sum, Object receiver) 
	//Purpose: user can use it to transact the money
	//Example: onlinePayment(Student,30.5,canteen)if students's balance is more than 30.5 then
	//canteen will receive the money and the students's deposit will reduce by 30.5 otherwise
	//it will mention that the user has insufficient balance
	//otherwise show You are not allowed to use this service
	public void onlinePayment(Object payer,double sum, Object receiver) throws FaiedTransaction {
		
		if(payer instanceof Business){
			//insufficient balance situation
			if(sum>((Business) payer).getDeposit()) {
				throw new FaiedTransaction();
			}
			else {
			((Business) payer).setDeposit(((Business) payer).getDeposit()-sum);
			((Person) receiver).setDeposit(((Business) payer).getDeposit()+sum);
			}	
		}
		
		if(payer instanceof Person && receiver instanceof Person){
			//insufficient balance situation
			if(sum>((Person) payer).getDeposit()) {
				throw new FaiedTransaction();
			}
			else {
			((Person) payer).setDeposit(((Person) payer).getDeposit()-sum);
			((Person) receiver).setDeposit(((Person) payer).getDeposit()+sum);
			}	
		}
		
		if(payer instanceof Person&&receiver instanceof Business){
			//insufficient balance situation
			if(sum>((Person) payer).getDeposit()) {
				throw new FaiedTransaction();
			}
			else {
			((Person) payer).setDeposit(((Person) payer).getDeposit()-sum);
			((Business) receiver).setDeposit(((Person) payer).getDeposit()+sum);
			}	
		}
		
		
	}
	

}
