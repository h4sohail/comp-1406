public class Employee extends Person{
  double weeklyBaseSalary;
  double totalPaid;
  double totalTaxed;
  private final double TAX_RATE_10 = 0.10;
  private final double TAX_RATE_15 = 0.15;

  public Employee(String iName, int iAge, double baseSal){
    super(iName, iAge);

    this.weeklyBaseSalary = baseSal;

  }
  /*
   * Should update the total amount paid/taxed for this employee. 
   * Taxes should be 10% of the weekly base salary for employees under the age of 30 
   * and 15% for employees aged 30 or older. 
   * The total paid to the employee should be the amount remaining after taxes are paid
   */
  public void pay(){
    //Code here
    if(getAge() < 30){
      totalTaxed = weeklyBaseSalary*TAX_RATE_10;
      totalPaid = weeklyBaseSalary - weeklyBaseSalary*TAX_RATE_10;
    }
    else{
      totalTaxed = weeklyBaseSalary*TAX_RATE_15;
      totalPaid = weeklyBaseSalary - weeklyBaseSalary*TAX_RATE_15;
    }
  }
  
  /*
   * Should return a String representing the employee�s pay cheque. 
   * The pay cheque must contain the following information: the employee�s name and age, 
   * the weekly base salary, the amount paid in taxes, the amount paid to the employee.
   */
  public String makePaycheque(){
    //Code here
    return String.format("Name: %s. Age: %s. Weekly Base Salary: %f. Taxes Paid: %f. " +
            "Net Income: %f", getName(), getAge(), weeklyBaseSalary, totalPaid);
  }
  
  //Add any additional methods you require here
}