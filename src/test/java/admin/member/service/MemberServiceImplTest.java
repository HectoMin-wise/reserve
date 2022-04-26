package admin.member.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    @Test
    void getMemberListString() {
        System.out.println(new MemberServiceImpl().getMemberListString());
    }

    @Test
    void getMemberString() {
        System.out.println(new MemberServiceImpl().getMemberString(1));
    }
}