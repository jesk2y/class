package org.movie.web;

import org.movie.dao.MovieDAO;
import org.movie.dao.QueryExecutor;
import org.movie.dao.ReviewDAO;
import org.movie.domain.MovieVO;
import org.movie.domain.ReviewVO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new MovieDAO().getList().stream().forEach(m -> System.out.println(m));

//        MovieVO vo = new MovieDAO().getMovie(4);
//        System.out.println(vo);
//        new ReviewDAO().getAllReviews(1).stream().forEach(r -> System.out.println(r));
//        new MovieDAO().getImgs(8).stream().forEach(img -> System.out.println(img));
//
//            ReviewVO vo = new ReviewVO();
//            vo.setMnum(4);
//            vo.setCmt("테스트");
//            vo.setScore(3);
//
//            new ReviewDAO().addReview(vo);

    }
}