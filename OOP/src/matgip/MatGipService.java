package matgip;

import java.util.ArrayList;

public class MatGipService {

    private ArrayList<MatGip> list;

    public MatGipService() {

        list = new ArrayList<>();
    }

    public void register(MatGip obj){
        list.add(obj);
        System.out.println(list);
    }

    public ArrayList<MatGip> findByPlace(String place){

        ArrayList<MatGip> arr = new ArrayList<>();

        for (MatGip vo:list){
            if (vo.checkArea(place)){
                arr.add(vo);
            }
        }
        return arr;
    }

}
