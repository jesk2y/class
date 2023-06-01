package org.zerock;

import org.zerock.searcher.AbstractSearcher;
import org.zerock.searcher.SearchFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("N or A ");

        String str = scanner.nextLine();

        SearchFactory factory = new SearchFactory();

        AbstractSearcher searcher = factory.find(str);

        System.out.println(searcher);

        searcher.search();

    }
}
