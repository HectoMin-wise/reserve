package controller.server.member.controller;

import controller.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinController {
    private Member member = new Member();



    public int join(String data) throws IOException {
            String idPatten = "^[a-z]+[a-z0-9]{5,19}$";// 정규식
            boolean checkedId =  data.matches(idPatten);
            if(checkedId) {
                member.setId(data);
                return 2;
            }else {
                return 4;
            }
    }
    public int userPasswd(String data){
        String passwdPatten = "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}$";// 정규식 적을것
        boolean checkedPasswd0 =  data.matches(passwdPatten);
        if(checkedPasswd0) {
            member.setPw(data);
           return 3;
        }else {
            return 6;
        }
    }
    public int memberPasswdSameCheck(String data){
        if (member.getPw().equals(data)){
            return 99;
        }
        return 2;
    }
}
