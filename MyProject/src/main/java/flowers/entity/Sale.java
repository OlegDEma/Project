package flowers.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="flowers_id")
	private Flowers flowers;
	
	private int number;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="purchase_id")
	private Purchase purchase;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	public Sale(){
		
	}



	public Sale(int id, int number) {
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

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", flowers=" + flowers + ", number=" + number + ", date=" + date + ", purchase="
				+ purchase + ", staff=" + staff + "]";
	}
	
	
	
	
	

}
