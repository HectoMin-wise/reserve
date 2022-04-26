package controller.server.member.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Member {
    private String id;
    private String pw;
    private Long memberIdx;
    private String nickname;
    private String name;
    private String phoneNumber;
    private Date joinDate;
    private Date leaveDate;
    private Long memberState;
}
