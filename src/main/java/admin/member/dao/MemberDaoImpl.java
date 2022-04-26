package admin.member.dao;

import admin.member.MemberState;
import admin.member.dto.MemberDto;
import admin.member.entity.Member;
import admin.member.querycontroller.MemberQuery;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    private MemberQuery mq = new MemberQuery();

    @Override
    public Long insertMember(Member member) {
        return null;
    }

    @Override
    public List<MemberDto> getMemberList(int page) {
        return mq.selectMemberList(page);
    }

    @Override
    public MemberDto getMember(int memberIdx) {
        return mq.selectMember(memberIdx);
    }

    @Override
    public void deleteMember(int memberIdx) {
        mq.updateMemberState(memberIdx, MemberState.DELETE.getStateCode());
    }

    @Override
    public void blockMember(int memberIdx) {
        mq.updateMemberState(memberIdx, MemberState.BLOCK.getStateCode());
    }

    @Override
    public void usingMember(int memberIdx) {
        mq.updateMemberState(memberIdx, MemberState.USING.getStateCode());
    }

    @Override
    public void outMember(int memberIdx) {
        mq.updateMemberState(memberIdx, MemberState.OUT.getStateCode());
    }


}
