package org.zerock.web;

import org.zerock.dao.BoardDAO;

public class Main {
    public static void main(String[] args) {
        BoardDAO.INSTANCE.addView(600);
    }
}
