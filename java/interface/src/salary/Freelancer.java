package salary;

public class Freelancer implements Salary {

    double yearSal;
    double lunch;

    @Override
    public double calc(){

        return yearSal+lunch;
    }
}
