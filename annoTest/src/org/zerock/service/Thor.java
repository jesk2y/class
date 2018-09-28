package org.zerock.service;

import org.zerock.anno.BGM;
import org.zerock.anno.Trailer;

@BGM("None")
public class Thor {

    @Trailer
    public void throwHammar(){
        System.out.println("망치 던지는 장면");
    }
}
