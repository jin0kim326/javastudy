package prob03;

import java.util.Objects;

public class Money {
	public int amount;
	
	public Money() {
		
	}
	

	public Money(int amount) {
		this.amount = amount;
	}
	

	/* 코드 작성 */
	public Money add(Money added) {
		return new Money(this.amount + added.amount);
	}

	public Money minus(Money minused) {
		return new Money(this.amount - minused.amount);
	}

	public Money multiply(Money multiplied) {
		return new Money(this.amount * multiplied.amount);
	}

	public Money devide(Money devided) {
		return new Money(this.amount / devided.amount);
	}

	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		// Object타입이 money인지 체크하기 
		if (!(obj instanceof Money)) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
}
