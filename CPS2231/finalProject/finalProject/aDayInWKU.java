package finalProject;

public class aDayInWKU {

	public static void main(String[] args) {
		String[] userDataBase = {"Bob123&1592564","Alice256&ali01235","abf5&05135","asdf&yui"}; 
		
		InternetServer localServer = new InternetServer(userDataBase);
		
		System.out.println("It is 5/29 2023 at 0:00 AM\nEveryone "
				+ "is sleeping, but our school server restarts and begins its work");
		Student aStudent = new Student("Bob","123456","cps",5);
		Apartment bamboo = new Apartment();
		System.out.println("I am Bob, a cps student, and I live in the Bamboo very close to the canteen,\n "
				+ "it is the end of this semester, so I only has 5 yuan left");
		localServer.verification(bamboo);
		System.out.println("It seems that I did not connect to the server that is why I cannot use the school service\n  "
				+ "(Bob are trying to connect to the server)");
		localServer.addTerminal(aStudent, "Bob123", "1592574");
		System.out.println("Like his steam, Bob forgot his code, what a poor guy.\n  "
				+ "(Bob are trying to change his code)");
		localServer.changeCode("Bob123", "1592574");
		localServer.addTerminal(aStudent, "Bob123", "1592574");
		
		System.out.println("Thanks God, just 8:00AM. Bob needs to get to Canteen for something to eat early");
		String[][] recipt = new String[][] {{"Eggs","2"},{"Milk","3.5"},{"OrangeJuice","7"}};
		Canteen aCanteen = new Canteen(156243002,true,"Canteen No.2","Canteen No.2",recipt);
		localServer.addTerminal(aCanteen, "abf5", "05135");
		aCanteen.deal("Noodels", aStudent, localServer);
		System.out.println("What a PITY!!!There is no more noodles, so Bob choose to drink a cup of orange juice");
		aCanteen.deal("OrangeJuice", aStudent, localServer);
		System.out.println("OH~~NO!!,Bob only has "+aStudent.getDeposit()+"Yuan, his only choice is an egg");
		aCanteen.deal("Eggs", aStudent, localServer);
		System.out.println(((Business)aCanteen).getRecords());
		String[][] storage = new String[][] {{"Water","1"},{"Milk","3.5"},{"pen","2"}};
		
		Store aStore = new Store(15060, true, "StudyArea", "十足", storage);
		localServer.addTerminal(aStore,"Alice256", "ali01235");
		System.out.println("At now, Bob only has "+aStudent.getDeposit()+" But DO NOT worry,"
				+ "he is working at the store,\n so the store will pay his salary of this semester");
		try {
			localServer.onlinePayment(aStore, 1000, aStudent);
		} catch (FaiedTransaction e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Congrats! Bob has "+aStudent.getDeposit()+"Yuan");
		Room room = new Room(407);
		bamboo.addApartmentMember(aStudent);
		bamboo.addRoom(room);
		
		System.out.println("Bob decided to go to the apartment to rest "
				+ "and relax with his friends Alen properly");
		
		Person Alen = new Person("Alen");
		if(bamboo.isApartmentMember(Alen)) {
		System.out.println("Alen is a member of bamboo");
		}
		else {
			System.out.println("Alen is not a member of bamboo");
		}
		
		System.out.println("However, since Alen does not belong to bamboo, "
				+"he needs to register as a temporary visitor to enter the dormitory");
		
		Person Chucky = new Person("Chucky 10");
		Person Alex = new Person("Alex 12");
		bamboo.addTemporaryVisitor("Chucky 10");
		bamboo.addTemporaryVisitor("Alex 12");
		bamboo.addTemporaryVisitor("Alen 13");
		
		System.out.println("Alen glanced at the temporary registration form"
			+ "there were other students on it");
		
		System.out.println("-----Temporary Registration-----");
		bamboo.getAllTemporaryVisitors();
		System.out.println("---------------------------------");
		
		System.out.println("After registering, "
				+ "Alen went to Bob's bedroom to play games together, "+
				" however, there was a sudden power outage");
		
		bamboo.setWaterAndElectricity(-0.9);
		bamboo.remindStudentsToChargeWaterAndElectricity();
		
		System.out.println("Then Bob started picking up his phone to pay the bill");
		InternetServer localServer1 = new InternetServer(new String[] {"Kean"});
		Person schoolPaymentOffice = new Person("schoolPaymentOffice");
		bamboo.chargeWaterAndElectricity(localServer1, aStudent, 30,schoolPaymentOffice);
		
		System.out.println("Then the dormitory had electricity again, and the two began to study CPS2231");
		
		Person Tom = new Person("Tom 18");
		Person Max = new Person("Max 21");
		bamboo.addTemporaryVisitor("Tom 18");
		bamboo.addTemporaryVisitor("Max 21");
		
		
		System.out.println("Unknowingly, after a busy day, "
				+ "the time came to 22:00, and Alen's visitor time as a student also arrived");
		
		bamboo.removeExpiredVisitors();
		System.out.println("-----Temporary Registration-----");
		bamboo.getAllTemporaryVisitors();
		System.out.println("---------------------------------");
		
		System.out.println("No name on visitor list, "
			+ "After a busy day, Bob and Alen are going to wash up and get ready for bed");
		
	}
	 
	 
}
