package org.zerock.domain;

import lombok.Data;

@Data
public class OrderVO {

    private int cno;
    private int qty;

    public OrderVO(){}

    public OrderVO(String str){
        String[] arr = str.split("_");
        if(arr.length != 2){
            return;
        }
        this.cno = Integer.parseInt(arr[0]);
        this.qty = Integer.parseInt(arr[1]);
    }
}