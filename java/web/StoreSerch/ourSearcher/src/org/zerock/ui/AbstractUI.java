package org.zerock.ui;

import org.zerock.searcher.AbstractSearcher;

import java.util.Scanner;

public abstract class AbstractUI {

    AbstractSearcher searcher;
    Scanner scanner;

    public AbstractUI(AbstractSearcher searcher, Scanner scanner) {
        this.searcher = searcher;
        this.scanner = scanner;
    }

    public abstract void interaction();

}
