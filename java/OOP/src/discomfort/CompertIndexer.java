package discomfort;

public class CompertIndexer {
    public double calc(double temp, double hum){
        double result = temp*(1.8)-(0.55*(1-(hum/100)))*(temp*(1.8)-26)+32;
        return result;
    }
}
