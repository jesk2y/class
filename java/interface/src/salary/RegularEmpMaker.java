package salary;

public class RegularEmpMaker extends AbstractMaker {

    @Override
    public Salary make() {
        System.out.println("정규직 만들기");
        RegularEmp obj = new RegularEmp();

        obj.yearSal = inputD("정규직의 연봉은 얼마인가요?");
        obj.lunch = inputD("정규직의 식대는 얼마인가요?");
        obj.extraPay = inputD("정규직의 추가수당은 얼마인가요?");
        return obj;
    }
}
