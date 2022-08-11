package dev.com.thejungle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "group_member_junction_table")
public class GroupMemberJunctionTable {

    @Column(name = "group_id")
    private int groupId;
    @Column(name = "user_id")
    private int userId;


    public GroupMemberJunctionTable() {
    }

    public GroupMemberJunctionTable(int groupId, int userId) {
        this.groupId = groupId;
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }




    
}
