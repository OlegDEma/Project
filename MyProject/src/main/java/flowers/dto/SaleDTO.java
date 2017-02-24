package flowers.dto;


public class SaleDTO {
	
	
	private int id;
	
	
	private int number;
	
	
	
	public SaleDTO(){
		
	}



	public SaleDTO(int id, int number) {
		super();
		this.id = id;
		this.number = number;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	
	
	
	

}
