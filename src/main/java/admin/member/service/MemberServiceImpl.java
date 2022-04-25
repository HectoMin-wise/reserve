package admin.member.service;

import admin.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
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
    public Member getMember(int member_idx) {
        return null;
    }

    @Override
    public void delMember(int member_idx) {

    }

    @Override
    public void hideMember(int member_idx) {

    }
}
