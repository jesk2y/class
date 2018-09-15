package salary;

public class RegularEmp implements Salary{

    double yearSal;
    double extraPay;
    double lunch;


    @Override
    public double calc() {
        return yearSal+extraPay+lunch;
    }
}
