package org.klozevitz.lightdigital.dto;

import lombok.Builder;
import lombok.Data;
import org.klozevitz.lightdigital.model.entities.Claim;
import org.klozevitz.lightdigital.model.entityAttributeEnums.ClaimStatus;

import java.util.Arrays;

@Data
@Builder
public class ClaimDTO {
    private int id;
    private String caption;
    private String phone;
    private String status;
    private String claim;
    private String comment;
    private int userId;

    public ClaimStatus getStatus() {
        if (status == null) {
            return ClaimStatus.ЧЕРНОВИК;
        }
        return Arrays.stream(ClaimStatus.values())
                .filter(s -> s.name().equals(status))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static ClaimDTO fromEntity(Claim claim) {
        return ClaimDTO.builder()
                .id(claim.getId())
                .caption(claim.getCaption())
                .phone(claim.getPhone())
                .status(claim.getStatus().name())
                .claim(claim.getClaim())
                .userId(claim.getUser().getId())
                .build();
    }
}
