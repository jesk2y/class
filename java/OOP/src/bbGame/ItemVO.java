package bbGame;

public class ItemVO {
    public ItemVO(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemVO{" +
                "value='" + value + '\'' +
                '}';
    }
    String value;
}
