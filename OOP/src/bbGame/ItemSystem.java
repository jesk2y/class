package bbGame;

import java.util.Arrays;
import java.util.Collections;

public class ItemSystem {

    ItemVO[] itemVOS;
    int idx;

    public ItemSystem(ItemVO[] itemVOS) {
        this.itemVOS = itemVOS;
        this.idx = 0;
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(itemVOS));
    }

    public ItemVO pick() {
        ItemVO result = this.itemVOS[idx];
        idx++;
        return result;
    }
}
