package jytest;

import java.util.List;
import java.util.Vector;

public class Test {
	
	
	public static void main(String[] args) {
		List<Client> connections = new Vector<Client>();
		
		connections.add(new Client());
		connections.add(new Client());
		connections.add(new Client());
		
		System.out.println(connections.size());
		
		connections.remove(connections.size()-1);
		System.out.println(connections.size());
		
		
	}
	
	static class Client {
		String name;
		public Client () {
			
		}
		public Client (String name) {
			this.name = name;
		}
		
	}
}