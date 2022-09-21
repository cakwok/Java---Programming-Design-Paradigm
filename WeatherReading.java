package Weather;

public class WeatherReading {
  private int airTemp;
  private int drewPoint;
  private int windSpeed;
  private int totalRain;

  public WeatherReading(int airTemp, int drewPoint, int windSpeed, int totalRain) throws IllegalArgumentException{
    if ((drewPoint > airTemp || windSpeed < 0 || totalRain <0)) {
      throw new IllegalArgumentException();
    }
    this.airTemp = airTemp;
    this.drewPoint = drewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
  }

  public int getTemperature() {
    return this.airTemp;
  }
  public int getDewPoint() { return this.drewPoint;}
  public int getWindSpeed() { return this.windSpeed;}
  public int getTotalRain() { return this.totalRain;}

  public int getRelativeHumidity() {
    int relativeHumidity;
    relativeHumidity = 5 * this.drewPoint - 5 * airTemp + 100;
    return relativeHumidity;
  }
  /*
  public double getHeatIndex() {
    double HI;
    //double[] C = {c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605, c5 = -0.012308094, c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, and c9 = -0.000003582}
    List<Integer> C
    return HI;
  }
  public dobule getWindChill() {

  }
   */
}
