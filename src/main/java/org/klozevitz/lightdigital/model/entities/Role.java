package org.klozevitz.lightdigital.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.klozevitz.lightdigital.model.BaseEntity;
import org.klozevitz.lightdigital.model.entityAttributeEnums.RoleName;

import java.util.List;

@Data
@Entity
@Table(name = "role_t")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleName role;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + super.getId() +
                ", role=" + role +
                '}';
    }
}
