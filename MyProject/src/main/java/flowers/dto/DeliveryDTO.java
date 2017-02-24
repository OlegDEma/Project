package flowers.dto;




public class DeliveryDTO {
	
	private int id;
	
	private int price;

	
	public DeliveryDTO(){
		
	}
	

	public DeliveryDTO(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	
	
	
	
	
	

}
