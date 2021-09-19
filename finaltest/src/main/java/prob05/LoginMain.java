package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMain {
	public static User loginedUser =null;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "둘리", "1234") );
		joinUsers.add( new User( "마이콜", "5678") );
		joinUsers.add( new User( "또치", "4321") );
		joinUsers.add( new User( "도우너", "8765") );
		joinUsers.add( new User( "또치또치", "1862") );
		
		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();

		try {
			login(joinUsers, new User( id, password) );
			System.out.println("로그인 성공");
		} catch (UserNotFoundException ex) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		} catch( PasswordDismatchException ex ){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		} finally {
			scanner.close();
		}
	}
	
	public static void login(List<User> users, User user ) throws UserNotFoundException {
		/* 코드 작성 */
		/************************************************************/
		String inputPassword = user.getPassword(); 	// 사용자가 입력한 패스워드
		
		// 1. UserList에서 입력된 아이디와 동일한 아이디가 있는지 검색 
		// 존재=> 2 / 없다=> UserNotFoundException
		
		if(!idExist(users, user)) {
			throw new UserNotFoundException();
		}
		
		
		// 2. 비밀번호 비교
		// 같으면 로그인성공, 틀리면 => passwordDismatchException 
		if (!passwordCheck(loginedUser, inputPassword)){
			throw new PasswordDismatchException();
		}
		
	}
	
	/************************************************************/
	// 메소드 1 : 입력한 아이디가 디비에 있는지 체크하는 메소드
	public static boolean idExist(List<User> users, User user) {
		boolean idIsExist = false;
		String inputId = user.getId();
		
		for ( User isUser : users) {
			String dbId = isUser.getId();	//db의 아이디 
			if (inputId.equals(dbId)) {
				loginedUser = isUser;		//디비의 User객체를 변수에 할당
				idIsExist = true;
			}
		}
		return idIsExist;
	}
	
	// 메소드 2 : 입력된id에 해당하는 패스워드와 인풋페스워드가 같은지 체크하는 메소드
	public static boolean passwordCheck(User loginedUser, String inputPassword) {
		if (loginedUser.getPassword().equals(inputPassword)) {
			return true;
		} else {
			return false;
		}
	}
	/************************************************************/
}
