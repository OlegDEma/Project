package flowers.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int number;
	
	private int price;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="providers_id")
	private Providers providers;
	
	@ManyToOne
	@JoinColumn(name="flowers_id")
	private Flowers flowers;
	
	
	
	public Delivery(){
		
	}	


	public Delivery(int number, int price, Flowers flowers) {
		super();
		this.number = number;
		this.price = price;
		this.date = date;
		this.flowers = flowers;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Providers getProvider() {
		return providers;
	}

	public void setProvider(Providers providers) {
		this.providers = providers;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}
	

	public Providers getProviders() {
		return providers;
	}

	public void setProviders(Providers providers) {
		this.providers = providers;
	}

//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", number=" + number + ", price=" + price + ", date=" + date + ", flowers="
				+ flowers + "]";
	}
	
	
	
	

}
