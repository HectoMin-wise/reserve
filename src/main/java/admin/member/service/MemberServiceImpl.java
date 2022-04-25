package admin.member.service;

import admin.member.dao.MemberDao;
import admin.member.dao.MemberDaoImpl;
import admin.member.dto.MemberDto;
import admin.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
public class MemberServiceImpl implements MemberService {
    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public List<Member> getMemberList(int page) {

        logger.info("사용법 변수는 중괄호에{}", 111);
        return null;
    }

    @Override
    public Member getMember(int memberIdx) {
        return null;
    }

    @Override
    public void delMember(int memberIdx) {

    }

    @Override
    public void hideMember(int memberIdx) {

    }

    @Override
    public String getMemberListString() {
        MemberDao memberDao = new MemberDaoImpl();
        List<MemberDto> memberList = memberDao.getMemberList(1);

        StringBuilder sb = new StringBuilder();

        for (MemberDto m : memberList) {
            sb.append(m.toString()).append("\n");
        }

        sb.append("DATE-SET");

        return sb.toString();
    }

    @Override
    public String getMemberString(int memberIdx) {
        MemberDao memberDao = new MemberDaoImpl();
        MemberDto memberDto = memberDao.getMember(memberIdx);

        StringBuilder sb = new StringBuilder();

        sb.append(memberDto.toString()).append("\n");
        sb.append("DATA-SET");

        return sb.toString();
    }
}
