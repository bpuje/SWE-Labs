public class Customer{
	private String customerId;
	private String name;
	private LocalDate dateOfBirth;

	public String getCustomerId(){
		return customerId;
	}

	public void setCustomerId(String customerId){
		this.customerId = customerId;
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