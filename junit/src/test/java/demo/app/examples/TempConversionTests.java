package demo.app.examples;

import demo.app.TempConversion;
import org.junit.Test;

import static org.junit.Assert.*;

public class TempConversionTests {

    @Test
    public void testTempConversionCtoF(){
        TempConversion temperatureConversion = new TempConversion();

        double temperature = 80.0;
        String unit = "";
        double result = temperatureConversion.tempConversion(temperature, unit);

        assertEquals(176.0d, result, 0.0);
    }

    @Test
    public void testTempConversionFtoC(){
        TempConversion temperatureConversion = new TempConversion();

        double temperature = 176.0;
        String unit = "f";
        double result = temperatureConversion.tempConversion(temperature, unit);

        assertEquals(80d, result, 0.0);
    }
}
