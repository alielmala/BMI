import java.util.*;
public class Bmi {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number of cities");
    int noOfcities, noOfPersons;
    noOfcities = input.nextInt();

    int under = 0, obese = 0, normal = 0, over = 0;
    int cityUnder = 0, cityObese = 0, cityNormal = 0, cityOver = 0;
    float personUnder, personOver, personObese, personNormal;
    double maxNormal = 0.0, maxObese = 0.0, minUnder = 100.0;
    String name, bestCity = "None", worstCity = "None", minUnderWeightCity = "None", cat;
    int mass, height;
    float bmi;

    for (int i = 0; i < noOfcities; i++) {
      System.out.println("Enter the name of city");
      name = input.next();
      System.out.println("Enter the number of persons");
      noOfPersons = input.nextInt();

      cityUnder = 0;
      cityObese = 0;
      cityNormal = 0;
      cityOver = 0;
      for (int j = 0; j < noOfPersons; j++) {
        System.out.println("Enter the mass and height");
        mass = input.nextInt();
        height = input.nextInt();
        bmi = mass / (height * height);

        if (bmi < 18.5) {
          cat = "underweight";
          cityUnder++;
        } else if (bmi >= 18.5 && bmi < 25) {
          cat = "normal";
          cityNormal++;
        } else if (bmi >= 25 && bmi < 30) {
          cat = "overweight";
          cityOver++;
        } else {
          cat = "obese";
          cityObese++;
        }
        System.out.println("The person has a BMI of " + bmi + " and belongs to category " + cat);
      }
      under += cityUnder;
      over += cityOver;
      normal += cityNormal;
      obese += cityObese;

      personUnder = (under / noOfPersons) * 100;
      personNormal = (normal / noOfPersons) * 100;
      personOver = (over / noOfPersons) * 100;
      personObese = (obese / noOfPersons) * 100;

      System.out.println("For the city " + name + " category wise breakup is:");
      System.out.println("Number of people who are Underweight: " + under + ", Percentage is: " + personUnder);
      System.out.println("Number of people who are Normal: " + normal + ", Percentage is: " + personNormal);
      System.out.println("Number of people who are Overweight: " + over + ", Percentage is: " + personOver);
      System.out.println("Number of people who are Obese: " + obese + ", Percentage is: " + personObese);

      if (personNormal > maxNormal) {
        maxNormal = personNormal;
        bestCity = name;
      }

      if (personObese > maxObese) {
        maxObese = personObese;
        worstCity = name;
      }

      if (personUnder < minUnder) {
        minUnder = personUnder;
        minUnderWeightCity = name;
      }

    }

    System.out.println("Number of Cities are: " + noOfcities);
    System.out.println("Best city is " + bestCity);
    System.out.println("Worst city is " + worstCity);
    System.out.println("The city which has the minimum percent of people in underweight category is " + minUnderWeightCity);

    input.close();
  }
}
