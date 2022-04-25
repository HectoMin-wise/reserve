package admin.member.dao;

import admin.member.dto.MemberDto;
import admin.member.entity.Member;
import admin.member.querycontroller.QueryController;
import org.junit.jupiter.api.Test;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoImplTest {

    private QueryController qc = new QueryController();

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