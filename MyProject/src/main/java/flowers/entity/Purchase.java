package flowers.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String pib;
	
	private String address;
	
	private int phone;
	
	@OneToMany(mappedBy="purchase")
	private List<Sale> sales;

	public Purchase(){
		
	}
	
	public Purchase(String pib, String address, int phone) {
		super();
		this.pib = pib;
		this.address = address;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", pib=" + pib + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
