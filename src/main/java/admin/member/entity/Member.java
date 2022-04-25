package admin.member.entity;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
