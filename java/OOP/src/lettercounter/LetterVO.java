package lettercounter;

public class LetterVO {
    char value;
    int count;

    public LetterVO(char value) {
        this.value = value;
        this.count = 0;
    }

    @Override
    public String toString() {
        return "LetterVO{" +
                "value=" + value +
                ", count=" + count +
                '}';
    }
}
