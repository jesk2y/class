package Salary;

public class DailyWorkerMaker extends AbstractMaker{

    @Override
    public Salary make() {
        System.out.println("일용직 만들기");
        DailyWorker obj = new DailyWorker();
        obj.pay = inputD("일용직의 시급을 입력하세요");
        obj.workhour = (int) inputI("일용직의 총 일한 시간을 입력하세요");
        return obj;
    }
}
