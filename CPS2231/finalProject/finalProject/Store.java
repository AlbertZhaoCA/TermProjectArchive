package finalProject;

import java.util.Date;

public class Store extends Business{
	//data field
	String[][] storageList;
	
	//Constructor
	Store(double deposit,boolean status,String LOCATION,String NAME,String[][] list){
		super.setDeposit(deposit);
		super.setStatue(status);
		super.setLocation(LOCATION);
		super.setName(NAME);
		addRecords("Open at"+new Date().toString());
		storageList = list;
	}
	
	//Every action needs a record for audit
	//Signature:public void addRecords(String records)
	//Example: addRecords("Student a got a pen costs 10 Yuan")
	//then  records will be like:
	//                           Open at xxxx
	//                           Student a got a pen costs 10 Yuan from store xxx
	@Override
	public void addRecords(String records) {
		super.getRecords().concat("\n" + records + "Store" + super.getName());
	}
	
	//Do the dealing with the customer
	//Signature:public void deal(String stuff,Object customer,InternetServer onlinePayment)
	public void deal(String stuff,Object customer,InternetServer onlinePayment) {
		for(int i = 0;i<storageList.length;i++) 
		if(storageList[i][0]==stuff) {
			double sum = Double.parseDouble(storageList[i][1]);
			try {
			onlinePayment.onlinePayment(customer, sum, this);
			}
			catch(FaiedTransaction t) {
			}
			addRecords("customer got a" + stuff + " cost " + sum + "Deposit at now: " +this.getDeposit());
		}
		else
			System.out.println("Sorry, we do not offer that stuff");
		
	}	
	
	
	
}
