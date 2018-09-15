package ramen;

public class ZazangRamen extends Ramen{
    @Override
    public void cook() {
        System.out.println("면이 익으면 물을 덜어낸다.");
        System.out.println("스프를 넣고 비빈다");
    }
    //이렇게 해도 문제는 없지만 맛없으므로 cook부분을 강제로 오버라이드 하게끔 만듬 - 추상클래스
}
