import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;



public class ChatServer {
 
 // 클라이언트와 클라이언트에 대한 스트림 저장
 private HashMap<String, BufferedWriter> clients;
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
   new ChatServer().start();
 }
 
 public ChatServer() {
  clients = new HashMap<>();
 }
 
 //서버 시작 메서드
 
 public void start() {
  ServerSocket serverSocket = null;
  Socket socekt = null;
  
  
  try {
   serverSocket = new ServerSocket(7777);
   
   System.out.println("서버가 시작되었습니다.");
   
   while(true) {
    socekt = serverSocket.accept(); //The method blocks until a connection is made. 
    System.out.println("접속되었습니다.");
    
    ServerReceiver serverReceiver = new ServerReceiver(socekt);
    serverReceiver.start();
   }
   
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

 }
 
 
 class ServerReceiver extends Thread {
  private Socket socket;
  private BufferedWriter bw;
  private BufferedReader br;
  
  public ServerReceiver(Socket socket) {
   this.socket = socket;
   
   try {
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
  
  // 모든 클라이언트에게 메세지 전송할 메서드
  public void sendToAll (String msg) {
   Iterator<String> it = clients.keySet().iterator();
   
   while(it.hasNext()) {
    try {
     BufferedWriter bw = (BufferedWriter)clients.get(it.next());
     bw.write(msg + "\n");
     bw.flush();
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   }
  }
  
  
  @Override
  public void run() {
   // TODO Auto-generated method stub
//   super.run();
   String name = "";
   
   try {
    
    name = br.readLine();
    
    sendToAll("#" + name + "님이 들어오셨습니다.");
    
    clients.put(name, bw);
    System.out.println("현재 서버 접속자는 " + clients.size() + " 입니다.");
    
    while(br != null) { // br이 끊길때까지 계속 읽어드림.
     
     String message = br.readLine();
     sendToAll(message);
     
     System.out.println(message); //서버를 실행한 명령프롬프트에서 Client 에서 보내는 메세지를 출력한다.
    }
    
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } finally {
    sendToAll("#" + name + "님이 나가셨습니다.");
    clients.remove(name);
    System.out.println("현재 서버 접속자는 " + clients.size() + " 입니다.");
   }
   
  }
 }

} 