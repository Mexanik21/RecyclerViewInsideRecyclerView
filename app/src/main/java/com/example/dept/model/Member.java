package com.example.dept.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String fullName;
    private ArrayList<MemberSub> memberSubs;

    public Member() {
    }

    public Member(String fullName, ArrayList<MemberSub> memberSubs) {
        this.fullName = fullName;
        this.memberSubs = memberSubs;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setMemberSubs(ArrayList<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }
}
