package server;

import store.*;

//Server should have a hashmap of all the brands. for reporting
public abstract class Server{
	public static boolean maintenance;

	public static void report(){
		return;
	}

	public static Report report(Brand b, int n_faulty){
		return Report();
	}

	public static void main(String[] args){
		while (maintenance == true){
			
		}
	} 

}