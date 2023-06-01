package salary;

public class ContractEmp implements Salary {

    double yearSal;
    double lunch;

    @Override
    public double calc() {
        return yearSal+lunch;
    }
}
