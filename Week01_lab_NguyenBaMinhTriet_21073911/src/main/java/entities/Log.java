package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account_id;

    private Date login_time;
    private Date logout_time;

    private String notes;


    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log() {
    }

    public Log(String notes, Date logout_time, Date login_time, Account account_id, int id) {
        this.notes = notes;
        this.logout_time = logout_time;
        this.login_time = login_time;
        this.account_id = account_id;
        this.id = id;
    }

    @Override
    public String toString() {
        return "log{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
