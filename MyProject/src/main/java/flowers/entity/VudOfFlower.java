package flowers.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VudOfFlower {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@OneToMany(mappedBy="vudOfFlower")
	private List<Flowers> flowers;
	
	public VudOfFlower(){
		
	}

	

	public VudOfFlower(String type) {
		super();
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Flowers getFlowers() {
		return (Flowers) flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = (List<Flowers>) flowers;
	}

	@Override
	public String toString() {
		return "VudOfFlower [id=" + id + ", type=" + type + ", flowers=" + flowers + "]";
	}
	
	
	
	

}
