package org.klozevitz.lightdigital.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.klozevitz.lightdigital.model.BaseEntity;
import org.klozevitz.lightdigital.model.entityAttributeEnums.ClaimStatus;

@Data
@Entity
@Table(name = "claim_t")
public class Claim extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ClaimStatus status;
    @Column(name = "claim")
    private String claim;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", claim='" + claim + '\'' +
                ", comment='" + comment + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
