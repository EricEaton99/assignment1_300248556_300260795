
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.lang.*;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP5Test
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
    PointCP5 pointCP2;
    PointCP5 pointCP3;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
      pointCP2 = new PointCP2(
        Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
      pointCP3 = new PointCP3(
              Double.valueOf(args[1]).doubleValue(),
              Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        pointCP2 = getInput('P');
        pointCP3 = getInput('C');
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("");
    System.out.println("pointCP2 is Polar: " + pointCP2.getRho() +", "+ pointCP2.getTheta());
    System.out.println("In Cartesian it is: " + pointCP2.getX() + ", " + pointCP2.getY());
    System.out.println("");

    long[] results = runManyNTimes(1000000, pointCP2);
    for(int i=0;i< results.length;i++){
      System.out.println("result "+i+" took: "+ ((double) results[i] / 1_000_000_000)+" s");
    }

    System.out.println("");
    System.out.println("pointCP3 is Cartesian: " + pointCP3.getX() + ", " + pointCP3.getY());
    System.out.println("In Polar it is: " + pointCP3.getRho() +", "+ pointCP3.getTheta());
    System.out.println("");

    results = runManyNTimes(1000000, pointCP3);
    for(int i=0;i< results.length;i++){
      System.out.println("result "+i+" took: "+ ((double) results[i] / 1_000_000_000)+" s");
    }


  }

  private static long[] runManyNTimes(int n, PointCP5 point){
    long[] tests = new long[8];
    long time;
    PointCP5 pointCP2 = new PointCP2(0.0, 0.0);
    PointCP5 pointCP3 = new PointCP3(0.0, 0.0);

    for(int j=0;j<tests.length;j++){
      tests[j] = 0;
    }

    for(int i=0;i<n;i++){
      for(int j=0;j<tests.length;j++){
        time = System.nanoTime();
        point.getX();
        tests[0] += System.nanoTime() - time;

        time = System.nanoTime();
        point.getY();
        tests[1] += System.nanoTime() - time;

        time = System.nanoTime();
        point.getRho();
        tests[2] += System.nanoTime() - time;

        time = System.nanoTime();
        point.getTheta();
        tests[3] += System.nanoTime() - time;

        time = System.nanoTime();
        point.getDistance(pointCP2);
        tests[4] += System.nanoTime() - time;

        time = System.nanoTime();
        point.getDistance(pointCP3);
        tests[5] += System.nanoTime() - time;

        time = System.nanoTime();
        point.rotatePoint(90.0);
        tests[6] += System.nanoTime() - time;

        time = System.nanoTime();
        point.toString();
        tests[7] += System.nanoTime() - time;
      }
    }
    return tests;
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @char coordType  C for Cartesian or P for Polar
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP5 getInput(char coordType) throws IOException
  {
    if(coordType != 'P' && coordType != 'C'){
      return null;
    }
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information

    //Information to be passed to the constructor
    double dbl[] = new double[2];
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 2; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid

        // Prompt the user
        System.out.print("Enter the value of "
                + (coordType == 'C'
                ? (i == 0 ? "X " : "Y ")
                : (i == 0 ? "Rho " : "Theta "))
                + "using a decimal point(.): ");

        // Get the user's input

        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
          buffer[k] = '\u0020';

        System.in.read(buffer);
        theInput = new String(buffer).trim();

        // Verify the user's input
        try
        {
          dbl[i] = Double.valueOf(theInput).doubleValue();
        }
        catch(Exception e)
        {
          System.out.println("Incorrect input");
          isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    PointCP5 point;
    point = coordType == 'P' ? new PointCP2(dbl[0], dbl[1]) : new PointCP3(dbl[0], dbl[1]);

    return (point);
  }
}