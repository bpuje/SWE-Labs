public class Customer{
	private int customerId;
	private String name;
	private LocalDate dateOfBirth;

	public int getCustomerId(){
		return customerId;
	}

	public void setCustomerId(int customerId){
		this.costomerId = customerId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Customer(){
	}

	public Customer(){

	}

	public Customer(customerId, name, dateOfBirth){
		this.customerId = customerId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	
}