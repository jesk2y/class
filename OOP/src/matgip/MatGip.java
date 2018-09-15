package matgip;

public class MatGip  {
    private String area;
    private String name;
    private String menu;

    public MatGip(String area, String name, String menu) {
        this.area = area;
        this.name = name;
        this.menu = menu;
    }

    public boolean checkArea(String area){
        return this.area.contains(area);
    }

    public boolean checkMenu(String menu){
        return this.menu.contains(menu);
    }

    public boolean checkName(String name){
        return this.name.contains(name);
    }

    @Override
    public String toString() {
        return "MatGip{" +
                "area='" + area + '\'' +
                ", name='" + name + '\'' +
                ", menu='" + menu + '\'' +
                '}';
    }
}
