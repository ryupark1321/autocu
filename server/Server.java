package server;

import store.*;


//Server should have a hashmap of all the brands. for reporting
public abstract class Server{
	public static boolean maintenance;

	public static void report(){
		return;
	}

	public static Report report(Brand b, int n_faulty){
		return new Report(b, n_faulty);
	}

	public static void main(String[] args){
	} 

}