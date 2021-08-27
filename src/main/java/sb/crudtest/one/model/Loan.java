package sb.crudtest.one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vno;
	
	@Column(name = "id")
	private long id;
	
	public long getVno() {
		return vno;
	}

	public void setVno(long vno) {
		this.vno = vno;
	}

	@Column(name = "amount")
	private String amount;
	
	@Column(name = "pay_take")
	private String payortake;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayortake() {
		return payortake;
	}

	public void setPayortake(String payortake) {
		this.payortake = payortake;
	}
	
}
