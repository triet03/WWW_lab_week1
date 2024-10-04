package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "roleID", nullable = false)
    private Role role_id;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account_id;

    private boolean granted;

    private String note;

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }


    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public boolean isGranted() {
        return granted;
    }

    public void setGranted(boolean granted) {
        this.granted = granted;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess(Role role_id, Account account_id, boolean granted, String note) {
        this.role_id = role_id;
        this.account_id = account_id;
        this.granted = granted;
        this.note = note;
    }

    public GrantAccess() {

    }

    @Override
    public String toString() {
        return "grant_access{" +
                "role_id=" + role_id +
                ", account_id=" + account_id +
                ", granted=" + granted +
                ", note='" + note + '\'' +
                '}';
    }
}
