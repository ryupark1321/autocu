package server;

import store.*;

import java.util.*;

class Report{
	private Brand brand;
	private int faults;
	private Quarter quarter;

	private class Quarter{
		private String quarter;
		private int quarterly_number;

		public Quarter(int n_faults){
			quarterly_number = n_faults;
			int month = Calendar.MONTH;
			if(month < 4){quarter = "1st";}
			else if(month < 7){quarter = "2nd";}
			else if(month < 10){quarter = "3rd";}
			else{quarter = "4th";}
		}
	}

	Report(Brand b, int n_faults){
		brand = b;
		faults = n_faults;
		quarter = new Quarter(n_faults);
	}

	Report add(int add_faults){
		faults += add_faults;
		return this;
	}

	Report quarterly_update(){
		quarter = new Quarter(0);
		return this;
	}
}