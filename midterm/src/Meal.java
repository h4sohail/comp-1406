//Represents a meal made up of up to maxItems food items
public class Meal{
  private FoodItem[] items; //stores all of the food items that are in the meal
  private static final int maxItems = 25;
  
  //Constructor should initialize all instance variables
  public Meal(){
   
  }
  
  //Add the given food item to the items array, if there is still room
  //If there is no room, do nothing.
  public void addFoodItem(FoodItem item){
    for(int i = 0; i<maxItems; i++){
      if(items[i] == null){
        items[i] = item;
        break;
      }
    }
  }
  
  //Return the FoodItem in the items array that has the largest number of calories
  //If there are ties, you may return any of the largest
  public FoodItem mostCalories(){
    int currMax = 0;
    FoodItem maxCalories = null;
    for(FoodItem item : items){
      if(item.getCalories()>currMax){
        currMax = item.getCalories();
        maxCalories = item;
      }
    }
    return maxCalories;
  }
  
  //Computes and returns the total number of calories of all food items in this meal
  public int calculateTotalCalories(){
    int currSum = 0;
    for(FoodItem item : items) {
      if (item != null) {
        currSum += item.getCalories();
      }
    }
    return currSum;
  }
}