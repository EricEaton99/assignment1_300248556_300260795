/**
 * This class is an abstract class for 2d point subclasses
 *
 * @author Eric Eaton
 * @author Matteo <LastName>
 * @version October 2022
 */
abstract class PointCP5
{
  //Instance methods **************************************************

  public abstract double getX() {}
  
  public abstract double getY() {}
  
  public abstract double getRho() {}
  
  public abstract double getTheta() {}
  
  **
   * Calculates the distance in between two points
   */
  public abstract double getDistance(PointCP5 pointB) {}

  /**
   * Rotates the specified point by the specified number of degrees.
   */
  public abstract PointCP5 rotatePoint(double rotation) {}

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public abstract String toString(){}
}