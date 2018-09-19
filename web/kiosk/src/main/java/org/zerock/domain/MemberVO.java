package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
    private String id,pw,name,addr;

    public MemberVO(){}
}
