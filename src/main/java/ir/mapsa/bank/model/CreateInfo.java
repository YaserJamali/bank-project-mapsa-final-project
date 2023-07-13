package ir.mapsa.bank.model;

import ir.mapsa.bank.model.enums.Role;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Embeddable
public class CreateInfo {
@Temporal(TemporalType.TIMESTAMP)
    private Date crateDateAndTime;

    private Role role;

    public Date getCrateDateAndTime() {
        return crateDateAndTime;
    }

    public CreateInfo setCrateDateAndTime(Date crateDateAndTime) {
        this.crateDateAndTime = crateDateAndTime;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public CreateInfo setRole(Role role) {
        this.role = role;
        return this;
    }
}
