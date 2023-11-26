package finalProject;

import java.util.Date;

public class Canteen extends Business {
	//data field
	String[][] dailyFoodsList;
	
	//Constructor
	public Canteen(double deposit,boolean status,String LOCATION,String NAME,String[][] list){
		super.setDeposit(deposit);
		super.setStatue(status);
		super.setLocation(LOCATION);
		super.setName(NAME);
		addRecords("Open at "+ new Date().toString());
		dailyFoodsList = list;
	}
	//Every action needs a record for audit
	//Signature:public void addRecords(String records)
	//Example: addRecords("Student a got a pen costs 10 Yuan")
	//then  records will be like:
	//                           Open at xxxx
	//                           Student a got a pen costs 10 Yuan from Canteen xxx
	@Override
	public void addRecords(String record) {
		super.setRecords(getRecords().concat("\n" + record + "Canteen  " + super.getName()));
		}
	
	//Do the dealing with the customer
		//Signature:public void deal(String stuff,Object customer,InternetServer onlinePayment)
		public void deal(String stuff,Object customer,InternetServer onlinePayment) {
			boolean isFind = false;
			boolean isPaid = true;
			for(int i = 0;i<dailyFoodsList.length;i++) 
				if(dailyFoodsList[i][0]==stuff) {
					isFind = true;
					double sum = Double.parseDouble(dailyFoodsList[i][1]);
					try {
					onlinePayment.onlinePayment(customer, sum, this);
					}
					catch(FaiedTransaction t) {
						isPaid =false;
					}
					if(isPaid)
					addRecords("customer ate " + stuff + " cost " + sum + " ");
							
				}
					if(!isFind)
					System.out.println("Sorry, we do not offer that foods");
			
		}	
	
}
