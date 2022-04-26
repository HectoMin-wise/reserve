package admin.member.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
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
