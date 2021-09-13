package prob3;

public class Sparrow extends Bird {

	public void sing() {
		System.out.println("참새("+ getName()+")는 소리내어 웁니다.");
	}
	
	public void fly() {
		System.out.println("참새("+ getName()+")는 날아다닙니다");
	}

	@Override
	public String toString() {
		return "참새"+ super.toString();
	}
}
