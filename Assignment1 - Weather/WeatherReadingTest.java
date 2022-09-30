package Weather;

import org.junit.Before;

public class WeatherReadingTest {

  private WeatherReading weatherReading1;

  @Before
  public void setUp() {
    weatherReading1 = new WeatherReading(23, 12,  3, 12);
  }

  @org.junit.Test
  public void getTemperature() {
    System.out.println(weatherReading1.getTemperature());
  }

  @org.junit.Test
  public void getDewPoint() {
    System.out.println(weatherReading1.getDewPoint());
  }

  @org.junit.Test
  public void getWindSpeed() {
    System.out.println(weatherReading1.getWindSpeed());
  }

  @org.junit.Test
  public void getTotalRain() {
    System.out.println(weatherReading1.getTotalRain());
  }

  @org.junit.Test
  public void getRelativeHumidity() {
    System.out.println(weatherReading1.getRelativeHumidity());
  }

  @org.junit.Test
  public void getHeatIndex() {
    System.out.println(weatherReading1.getHeatIndex());
  }

  @org.junit.Test
  public void getWindChill() {
    System.out.println(weatherReading1.getWindChill());
  }

  @org.junit.Test
  public void PrintReading() {
    System.out.println(weatherReading1);
  }
}
