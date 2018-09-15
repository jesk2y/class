package order;

public class Main2 {
    public static void main(String[] args) {
        Menu[] arr = new Menu[5];

        arr[0] = new Menu("떡볶이", "소", 3000.0);
        arr[1] = new Menu("만두", "중", 3500.0);
        arr[2] = new Menu("치즈라면", "대", 4500.0);
        arr[3] = new Menu("순대", "소", 3000.0);
        arr[4] = new Menu("비빔밥", "중", 4500.0);

        OrderSystem obj = new OrderSystem(arr);
        obj.showMenus();
        obj.order();
    }
}
