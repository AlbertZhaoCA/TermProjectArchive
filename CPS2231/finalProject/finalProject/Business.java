package finalProject;

public abstract class Business {
	
	private double deposit;
	private boolean statue;
	private String records =" " ;
	private String location;
	private String name;
	
	
	//getter and setter for dataField
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public boolean isStatue() {
		return statue;
	}

	public void setStatue(boolean statue) {
		this.statue = statue;
	}

	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records=records;
		
	}
	
	//abstract method to add records when dealing
	public abstract void addRecords(String records);

	
}
