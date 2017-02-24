package flowers.dto;



public class StaffDTO {
	
	
	private int id;
	
	private String pib;
	
	
	public StaffDTO(){
		
	}


	public StaffDTO(int id, String pib) {
		super();
		this.id = id;
		this.pib = pib;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPib() {
		return pib;
	}


	public void setPib(String pib) {
		this.pib = pib;
	}
	
	

	
	
	
	

}
