package salary;

public class ContractEmpMaker extends AbstractMaker {

    @Override
    public Salary make() {
        System.out.println("계약직 만들기");
        ContractEmp obj = new ContractEmp();

        obj.yearSal = inputD("계약직의 연봉은 얼마입니까?");
        obj.lunch = inputD("계약직의 식대는 얼마입니까?");

        return obj;
    }
}
