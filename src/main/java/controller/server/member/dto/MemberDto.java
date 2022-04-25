package controller.server.member.dto;

import controller.server.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberDto {
    private List<Member> memberList;
    private Member  member;
}
