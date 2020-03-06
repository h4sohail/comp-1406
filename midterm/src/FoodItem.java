public class FoodItem{
  private String name;
  private int calories;
  
  public FoodItem(String iName, int iCals){
    name = iName;
    calories = iCals;
  }
  
  public void setName(String newName){
    name = newName;
  }
  
  public void setCalories(int newCals){
    calories = newCals;
  }
  
  public int getCalories(){
    return calories;
  }
  
  public String getName(){
    return name;
  }
}