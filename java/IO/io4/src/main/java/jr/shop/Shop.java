package jr.shop;

public class Shop {

    private String name;
    private String style;
    private String link;
    private String view;
    private String click;

    public Shop(String name, String style, String link, String view, String click) {
        this.name = name;
        this.style = style;
        this.link = link;
        this.view = view;
        this.click = click;
    }


    public String getStyle() {
        return style;
    }

    public String getLink() {
        return link;
    }

    public boolean checkStyle(String sName){
        return this.style.contains(sName);
    }
    public String getName() {
        return this.name;
    }
    public String getView() {
        return this.view;
    }
    public String getClick() {
        return this.click;
    }
    @Override
    public String toString() {
        return
                "Daily-view: " + this.view + "\n"+
                " / Daily-click: " + this.click + " / " ;
    }
}
