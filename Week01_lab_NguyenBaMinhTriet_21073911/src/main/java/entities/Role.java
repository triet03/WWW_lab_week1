package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private String role_id;
    private String role_name;
    private String role_description;
    private int status;

    public Role() {

    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Role(String role_id, String role_name, String role_description, int status) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_description = role_description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_description='" + role_description + '\'' +
                ", status=" + status +
                '}';
    }
}
