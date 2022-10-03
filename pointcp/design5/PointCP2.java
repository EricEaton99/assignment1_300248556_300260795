public class PointCP2 extends PointCP5
{

  private double rho;

  private double theta;

  public PointCP2(double rho, double theta)
  {
    this.rho = rho;
    this.theta = Math.toRadians(theta);
  }
	

  public double getX()
  {
    return (Math.cos(theta) * rho);
  }
  
  public double getY()
  {
    return (Math.sin(theta) * rho);
  }
  
  public double getRho()
  {
    return rho;
  }
  
  public double getTheta()
  {
    return Math.toDegrees(theta);
  }


  public double getDistance(PointCP2 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }


  public PointCP2 rotatePoint(double rotation)
  {
    return new PointCP2(rho, Math.toDegrees(theta)+rotation);
  }


  public String toString()
  {
    return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
  }
}
