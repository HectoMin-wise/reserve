package admin.member;

public enum MemberState {
    USING("이용중", 1),
    BLOCK("이용정지", 0),
    OUT("탈퇴", 2);

    private String stateName;
    private int stateCode;

    MemberState(String stateName, int stateCode) {
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public int getStateCode() {
        return stateCode;
    }
}
