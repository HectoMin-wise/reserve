package admin.member.dto;

import admin.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberDto {
    private List<Member> noticeList;
    private Member Notice;
}
