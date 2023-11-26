package finalProject;

import java.util.ArrayList;
public class Apartment {
     private double waterAndElectricity;
     private ArrayList<Person> apartmentMembers;
     private ArrayList<Room> rooms;
     private ArrayList<String> temporaryVisitors;
     
     public Apartment() {
         apartmentMembers = new ArrayList<>();
         rooms = new ArrayList<>();
         temporaryVisitors = new ArrayList<>();
         
     }
     
     //the way to write the temporaryVisitors in a list
     //every time use it need the name and room
     public void addApartmentMember(Person person) {
         apartmentMembers.add(person);
     }
     
     public void addRoom(Room room) {
         rooms.add(room);
     }
     
     public boolean isApartmentMember(Person person) {
         return apartmentMembers.contains(person);
     }
     
     public void getAllApartmentMember() {
      for(int i=0;i<apartmentMembers.size();i++) {
      System.out.println(apartmentMembers.get(i));
       }
     }
     
     //The string contains the name and times(1-24)
     public void addTemporaryVisitor(String name) {
         temporaryVisitors.add(name);
     }
     
     public void removeExpiredVisitors() {
         
         ArrayList<String> visitorsToRemove = new ArrayList<>();
         
         for (String visitor : temporaryVisitors) {
          
          int k = 0;
       for (int i = 0; i < visitor.length(); i++) {
        if (Character.isDigit(visitor.charAt(i))) {
         k = k + Integer.parseInt(visitor.charAt(i) + "");
         
         }
                  }
             if (k<22) {
                 visitorsToRemove.add(visitor);
             }
         }
         
         temporaryVisitors.removeAll(visitorsToRemove);
     }
     
     public void getAllTemporaryVisitors() {
      for(int i=0;i<temporaryVisitors.size();i++) {
      System.out.println(temporaryVisitors.get(i));
       }
     }
     
     
   //WaterAndElectricity system in the apartment
     public void chargeWaterAndElectricity(InternetServer i,Person persons,double money,Person receiver) {
         System.out.println("Charging water and electricity for the apartment.");
         try {
			i.onlinePayment(persons, money, receiver);
		} catch (FaiedTransaction e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public double getwaterAndElectricity() {
      return waterAndElectricity;
     }
     
     public void setWaterAndElectricity(double waterAndElectricity) {
      this.waterAndElectricity = waterAndElectricity;
     }
     
     public void remindStudentsToChargeWaterAndElectricity() {
      
         for (Person member : apartmentMembers) {
             if (waterAndElectricity<0) {
                 System.out.println("Reminder: " + member.getName() + ", please charge water and electricity."
                   +" the water and electricity is only " + this.getwaterAndElectricity());
             }
         }
     }
     
}
