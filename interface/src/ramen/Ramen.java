package ramen;

public abstract class Ramen { // 추상클래스는 인스턴스 안만듬(참조변수 안만듬)
    public void bolingWater() {
        System.out.println("뮬끊이기");
    }

    public abstract void cook();
    // 이부분만 강제로 오버라이드로 빼고싶어짐
    //이건 그냥 타입으로 존재하는거이므로 실제 동작할게 없음 그래서 클래스에도 abstract 붙여줌

    public void dish() {
        System.out.println("접시에 담기");
    }
}
