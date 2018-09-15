package ramen;

public class SoupRamen extends Ramen {

    @Override // 안써도 되는데 재정의했다는 표시하려고 씀
    public void cook() {
        System.out.println("면과 스프를 넣고 4분동안 기다리세요");
    }
}
