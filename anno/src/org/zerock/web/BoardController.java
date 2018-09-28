package org.zerock.web;

import org.zerock.anno.GetMapping;
import org.zerock.anno.RequestMapping;
import org.zerock.anno.RequestParam;

@RequestMapping("/board/")
public class BoardController {

    @GetMapping("/board/register.co")
    public void add(){}

    @GetMapping("/board/list.do")
    public void getList(@RequestParam("page") String pageSTR){
        System.out.println("list called....");
    }
}
