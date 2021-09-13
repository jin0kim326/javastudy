package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sing() {		
		System.out.println("새("+ getName()+")는 소리내어 웁니다.");
	}
	
	public void fly() {
		System.out.println("새("+ getName()+")는 날아 다닙니다.");
	}

	@Override
	public String toString() {
		return "의 이름은 "+name+" 입니다.";
	}	
}
