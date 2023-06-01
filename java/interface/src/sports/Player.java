package sports;

public class Player implements Comparable<Player>{  //비교하고 싶으면 comparable 붙임

    private String name;
    public double rate;

    public Player(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        System.out.println(this);
        System.out.println(o);
        System.out.println("----------------------");

        if(o.rate > this.rate){
            return 1;
        }else if(o.rate < this.rate){
            return -1;
        }
        return 0;   //자리바꿀일 없음
    }
}
