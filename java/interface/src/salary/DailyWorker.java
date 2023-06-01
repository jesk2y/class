package salary;

public class DailyWorker implements Salary{

    int workhour;
    double pay;


    @Override
    public double calc() {

        return workhour*pay;
    }
}
