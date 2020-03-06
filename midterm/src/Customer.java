public class Customer{
  double money;
  
  public Customer(){
    this(0.0);
  }
  
  public Customer(double initMoney){
    money = initMoney;
  }
  
  public double getMoney(){
    return money;
  }
  
  public void setMoney(double newMoney){
    money = newMoney;
  }

  public boolean isRicherThan(Customer other){
    if(money > other.getMoney()){
      return true;
    }
    else{
      return false;
    }
  }
}