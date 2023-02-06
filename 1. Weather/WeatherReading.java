package Weather;
import java.lang.Math;

public class WeatherReading {
  private int T;
  private int D;
  private int v;
  private int totalRain;

  public WeatherReading(int airTemp, int drewPoint, int windSpeed, int totalRain) throws IllegalArgumentException{
    if ((drewPoint > airTemp || windSpeed < 0 || totalRain <0)) {
      throw new IllegalArgumentException();
    }
    this.T = airTemp;
    this.D = drewPoint;
    this.v = windSpeed;
    this.totalRain = totalRain;
  }

  public int getTemperature() {
    return this.T;
  }
  public int getDewPoint() { return this.D;}
  public int getWindSpeed() { return this.v;}
  public int getTotalRain() { return this.totalRain;}

  public int getRelativeHumidity() {
    int relativeHumidity = 5 * this.D - 5 * this.T + 100;
    return relativeHumidity;
  }

  public double getHeatIndex() {
    double c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605, c5 = -0.012308094, c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, c9 = -0.000003582;
    int T = this.T;
    int R = getRelativeHumidity();
    double HI = c1 + c2 * T + c3 * R + c4 * T * R + c5 * Math.pow(T, 2) + c6 * Math.pow(R, 2) + c7 * Math.pow(T, 2) * R + c8 * T * Math.pow(R, 2) + c9 * Math.pow(T, 2) * Math.pow(R, 2);
    return HI;
  }
  public double getWindChill() {
    double WC = 35.74 + 0.6215 * this.T - 35.75 * Math.pow(this.v, 0.16) + 0.4275 * this.T * Math.pow(this.v, 0.16);
    return WC;
  }

  public String toString(){
    String returnText = "Reading: T = " + this.T + " D = " + this.D + " v = " + this.v + " rain = " + this.totalRain;
    return returnText;
  }
}
