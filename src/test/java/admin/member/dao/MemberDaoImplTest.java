package admin.member.dao;

import admin.member.dto.MemberDto;
import admin.member.querycontroller.MemberQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberDaoImplTest {

    private MemberQuery qc = new MemberQuery();

    @Test
    void getMemberList() {
        List<MemberDto> memberList = qc.selectMemberList(1);
        StringBuilder sb = new StringBuilder();

        for (MemberDto m : memberList) {
            sb.append(m.toString()).append("\n");
        }
        sb.append("DATE-SET");

        System.out.println(sb.toString());
    }

    @Test
    void getMember() {
        List<MemberDto> memberList = qc.selectMemberList(1);
        StringBuilder sb = new StringBuilder();

        for (MemberDto m : memberList) {
            sb.append(m.getMemberIdx()).append("\n");

        }
        sb.append("DATE-SET");

        System.out.println(sb.toString());
    }
}