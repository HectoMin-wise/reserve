package admin.member.dao;

import admin.member.dto.MemberDto;
import admin.member.entity.Member;

import java.util.List;

public interface MemberDao {
    Long insertMember(Member member);

    List<MemberDto> getMemberList(int page);

    MemberDto getMember(int memberIdx);

    void deleteMember(int memberIdx);

    void suspensionMember(int memberIdx);

    void comebackMember(int memberIdx);
}
