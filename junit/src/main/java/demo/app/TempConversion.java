package demo.app;

public class TempConversion {
    public double tempConversion(double temp, String unit){
        if(unit.equals("f"))
            return (temp - 32) * (5.0 / 9.0);
        else{
            return (temp * (9.0 / 5.0)) + 32;
        }
    }
}
