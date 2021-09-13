package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {

//		if (function.equals("앱")) {
//			playApp();
//		} else if(function.equals("음악")){
//			playMusic();
//		} else if(function.equals("통화")) {
//			super.execute(function);
//		} else {
//			System.out.println("구현되지 않은 기능입니다.");
//		}
		
		
		
		if(function.equals("통화")) {
			super.execute(function);
		} else if (function.equals("음악")) {
			playMusic();
		} else if (function.equals("앱")) {
			playApp();
		} else {
			System.out.println("구현되지 않은 기능입니다.");
		}
	}
	
	public void playMusic() {
		System.out.println("다운로드해서 음악재생.");
	}
	
	public void playApp() {
		System.out.println("앱 실행 ");
	}
	
	
}
