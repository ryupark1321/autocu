package store;

public class Brand{
  public String serviceNumber;
  public int error_num; //number of faulty item occurrences
  public String name; // name of the brand.
  public int total_items; 

  //this class is mostly for the server
  public Brand(String n, String number, int e, int t){
    serviceNumber = number;
    error_num = e;
    name = n;
    total_items = t;
  }

  public void file_report(Item[] faulty_items, int num){
    error_num += num;
    for (int i=0; i < num; i++){
      faulty_items[i].showInfo();
    }
  }

  public void getStats(){
      System.out.println("Total Number of Items Delivered:  " + total_items);
      System.out.println("Number of Faulty Items Delivered:  " +  error_num);
      System.out.println("Percentage of Faulty Items:  " + error_num/total_items);
  }

  public boolean equals(Brand b){
    return (serviceNumber.equals(b.serviceNumber)) && (error_num == b.error_num) && (name.equals(b.name)) && (total_items == b.total_items);
  }

  public String toString(Brand b){
    return b.name;
  }

}