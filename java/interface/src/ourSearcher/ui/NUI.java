package ourSearcher.ui;
import ourSearcher.searcher.AbstractSearcher;
import java.util.Scanner;

public abstract class NUI extends AbstractUI{
    public NUI(AbstractSearcher searcher, Scanner scanner) {
        super(searcher, scanner);
    }

    @Override
    public void interaction(){

    }

}
