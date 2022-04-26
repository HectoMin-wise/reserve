package admin.member.service;

import admin.member.entity.Member;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public interface MemberService {
    List<Member> getMemberList(int page);
    Member getMember(int memberIdx);
    void delMember(int memberIdx);
    void hideMember(int memberIdx);
    String getMemberListString();
    String getMemberString(int memberIdx);

    void sendMemberListStream(Socket socket) throws IOException;

    void sendMemberStream(Socket socket, int memberIdx) throws IOException;
}
