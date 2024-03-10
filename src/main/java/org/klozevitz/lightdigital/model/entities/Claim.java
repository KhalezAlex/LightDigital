package org.klozevitz.lightdigital.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.klozevitz.lightdigital.dto.ClaimDTO;
import org.klozevitz.lightdigital.model.BaseEntity;
import org.klozevitz.lightdigital.model.entityAttributeEnums.ClaimStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "claim_t")
public class Claim extends BaseEntity {
    @Column(name = "caption")
    private String caption;
    @Column(name = "phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ClaimStatus status;
    @Column(name = "claim")
    private String claim;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created")
    private LocalDate created;
    @Column(name = "updated")
    private LocalDate updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + super.getId() + '\'' +
                "caption='" + caption + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", claim='" + claim + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                '}';
    }

    public static Claim fromDTO(ClaimDTO dto) {
        Claim claim =  Claim.builder()
                .caption(dto.getCaption())
                .phone(dto.getPhone())
                .status(dto.getStatus())
                .claim(dto.getClaim())
                .comment(dto.getComment())
                .build();
        claim.setId(dto.getId());
        return claim;
    }
}
