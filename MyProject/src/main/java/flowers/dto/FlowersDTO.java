package flowers.dto;


public class FlowersDTO {
	
	
	private int id;
	
	private String name;
	
	private int price;
	
	private String pImage;
	
	private int height;
	
	
public FlowersDTO(){
		
	}


public FlowersDTO(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public String getpImage() {
	return pImage;
}


public void setpImage(String pImage) {
	this.pImage = pImage;
}


public int getHeight() {
	return height;
}


public void setHeight(int height) {
	this.height = height;
}



	
	
	

	
	
	
	
	
	
	

}
