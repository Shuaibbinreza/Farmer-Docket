package sb.crudtest.one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "earning")
public class Earning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tc;
	
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "revenue")
	private String revenue;
	
	
	public long getTc() {
		return tc;
	}

	public void setTc(long tc) {
		this.tc = tc;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

}
