package lettercounter;

public class LetterVOFinider {
    LetterVO[] vos;


    public LetterVOFinider() { // 받을게 필요할때
        this.vos = new LetterVO[26];
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 65);
            this.vos[i] = new LetterVO(ch);
        }
    }

    public LetterVO findByChar(char ch){

        int value = (int)ch;
        LetterVO result = this.vos[value-65];

        return result;
    }

//    public static void main(String[] args) {
//        LetterVOFinider finder = new LetterVOFinider();
//
//        LetterVO vo = finder.findByChar('A');
//        System.out.println(vo);
//    }

}
