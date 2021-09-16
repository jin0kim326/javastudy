package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
				
			
			String request = null;
			while (true) {
				String line = br.readLine();
				
				// 브라우저가 연결을 끊으면, 
				if (line == null) {
					break;
				}
				
				// SimpleHttpServer에서는 요청의 헤더만 읽음
				if ("".equals(line)) {
					break;
				}
				
				// 헤더 첫번째 라인만 읽음 
				if ( request == null) {
					request = line;
					break ;
				}
			}
			consoleLog(request);
			
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				consoleLog("request: " + tokens[1]);
				responseStaticResource(outputStream, tokens[1], tokens[2]);
				
				
			} else {
				// metohds : POST, PUT, DELETE, HEAD, CONNECT 등등
				// SimpleHttpServer 에서는 무시 (400 Bad Request 처리)
				//과제 : response400Error(outputStream, tokens[1], tokens[2]) 작성하기 
			}
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( (protocol+"200 OK\n").getBytes( "UTF-8" ) );
//			
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
//			
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( body );


		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(
			OutputStream outputStream, 
			String url, 
			String protocol) throws IOException {
		
			// welcome File set 
			if ("/".equals(url)) {
				url = "/index.html";
			}
			
			File file = new File(DOCUMENT_ROOT + url);
			if (!file.exists()) {
				// response404Error(outputStream, url , protocol);
//				outputStream.write( (protocol+"200 OK\n").getBytes( "UTF-8" ) );
//				outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//				outputStream.write( "\r\n".getBytes() );
//				outputStream.write( body );
				return;
			}
			
			byte[] body = Files.readAllBytes(file.toPath());
			String contentType = Files.probeContentType(file.toPath());
			outputStream.write( (protocol+"200 OK\n").getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
			outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
			outputStream.write( "\r\n".getBytes() );
			outputStream.write( body );

	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
