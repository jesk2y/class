package salary;

public class FreelancerMaker extends AbstractMaker{

    @Override
    public Salary make() {
        System.out.println("프리랜서 만들기");
        Freelancer obj = new Freelancer();

        obj.yearSal = inputD("프리랜서의 연봉은 얼마인가요?");
        obj.lunch = inputD("프리랜서의 식대는 얼마인가요?");
        return obj;
    }
}