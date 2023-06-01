package ourSearcher.domain;

public class Store {

    private String name;
    private double lat, lng;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", desc='" + desc + '\'' +
                '}';
    }
}
