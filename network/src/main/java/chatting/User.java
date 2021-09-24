package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import chatting.ChatServer;

/* 
 * 이 Client객체는 "서버와 연결된 클라이언트"를 관리하기 위한 객체 즉 "서버와 연결된 클라이언트"를 의미 
 * 서버가 시작되고, 클라이언트와 연결을 기다리다(accpet()) 클라이언트가 연결될 때마다 
 * 클라이언트를 객체를 생성하고, 컬렉션(List)에 add하여 관리 
 * 
 * 1. 생성자함수
 *    => Client객체가 생성되면 호출되는 함수로써, 해당 프로젝트에서는 
 *       - 첫 번째로 받아온 인풋을 nickName 변수에 할당 
 *       - 생성된 객체(본인) List에 add 
 *       - receive() 호출 : 객체가 생성되었다는것은 연결되었다는 뜻이고, 바로 데이터를 받을 준비를 함 
 * 2. receive() 
 * 3. sendAll(), send() 
 * */
class User {
	Socket socket=null;
	String nickName=null;
	
	public User (Socket socket, String nickName) {
		// 매개변수로 받은 socket을 멤버변수로 설정 
		this.socket = socket;
		this.nickName = nickName;
	}
}

