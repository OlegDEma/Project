package flowers.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Flowers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int height;
	
	private int widthOfGorshk;
	
	private int price;
	
	private int number;
	
	private String pImage;
	
	@ManyToOne
	private VudOfFlower vudOfFlower;
	
	@OneToMany(mappedBy="flowers")
	private List<Delivery> delivery;
	
	@OneToMany(mappedBy="flowers")
	private List<Sale> sales;
	
	@ManyToMany
	@JoinTable(name = "user_flowers", joinColumns = @JoinColumn(name = "flowers_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users ;
	
public Flowers(){
		
	}

	public Flowers(String name, int height, int widthOfGorshk, int price,int number) {
		super();
		this.name = name;
		this.height = height;
		this.widthOfGorshk = widthOfGorshk;
		this.price = price;
		this.number = number;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidthOfGorshk() {
		return widthOfGorshk;
	}

	public void setWidthOfGorshk(int widthOfGorshk) {
		this.widthOfGorshk = widthOfGorshk;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void getNumber(int number) {
		this.number = number;
	}

	public VudOfFlower getVudOfFlower() {
		return vudOfFlower;
	}

	public void setVudOfFlower(VudOfFlower vudOfFlower) {
		this.vudOfFlower = vudOfFlower;
	}
	

	public List<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}
	

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Flowers [id=" + id + ", name=" + name + ", height=" + height + ", widthOfGorshk=" + widthOfGorshk
				+ ", price=" + price + ", number=" + number + "]";
	}
	
	
	
	
	
	
	

}
