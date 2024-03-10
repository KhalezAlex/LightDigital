package org.klozevitz.lightdigital.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lightdigital.dto.ClaimDTO;
import org.klozevitz.lightdigital.dao.serviceInterfaces.ClaimService;
import org.klozevitz.lightdigital.dao.serviceInterfaces.UserService;
import org.klozevitz.lightdigital.model.entities.Claim;
import org.klozevitz.lightdigital.model.entityAttributeEnums.ClaimStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/claim")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;
    private final UserService userService;

    @PostMapping("/draft")
    public ClaimDTO createDraft(@RequestBody ClaimDTO dto) {
        return ClaimDTO.fromEntity(save(dto));
    }

    private Claim save(ClaimDTO dto) {
        Claim claim = Claim.fromDTO(dto);
        claim.setUser(userService.findById(dto.getUserId()));
        claim.setCreated(LocalDate.now());
        claim.setUpdated(LocalDate.now());
        return claimService.save(claim);
    }
}
