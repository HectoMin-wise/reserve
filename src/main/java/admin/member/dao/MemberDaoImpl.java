package admin.member.dao;

import admin.member.MemberState;
import admin.member.dto.MemberDto;
import admin.member.entity.Member;
import admin.member.querycontroller.QueryController;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    private QueryController qc = new QueryController();

    @Override
    public Long insertMember(Member member) {
        return null;
    }

    @Override
    public List<MemberDto> getMemberList(int page) {
        return qc.selectMemberList(page);
    }

    @Override
    public MemberDto getMember(int memberIdx) {
        return qc.selectMember(memberIdx);
    }

    @Override
    public void deleteMember(int memberIdx) {
        qc.updateMemberState(memberIdx, MemberState.OUT.getStateCode());
    }

    @Override
    public void suspensionMember(int memberIdx) {
        qc.updateMemberState(memberIdx, MemberState.BLOCK.getStateCode());
    }

    @Override
    public void comebackMember(int memberIdx) {
        qc.updateMemberState(memberIdx, MemberState.USING.getStateCode());
    }
}
