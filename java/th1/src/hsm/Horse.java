package hsm;

public class Horse extends Thread{

    private int pos;
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        gallop();
    }

    public void gallop(){

        for(int i=0; i<100; i++){

            int amount = (int)(Math.random() * 10);
            this.pos += amount;

            int count = this.pos/10;

            synchronized (System.out){
                for(int j=0; j<count; j++){
                    System.out.print(".");
                }
                System.out.println(this.name + ":" + this.pos);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end for

    }
}
