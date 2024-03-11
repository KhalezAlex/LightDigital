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
@RequestMapping("/api/user/claim")
@RequiredArgsConstructor
public class UserController {
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

    @PatchMapping
    public ClaimDTO patchDraft(@RequestBody ClaimDTO dto) {
        Claim draftToPatch = claimService.findById(dto.getId());
        if (!draftToPatch.getStatus().equals(ClaimStatus.ЧЕРНОВИК)) {
            return null;
        }
        draftToPatch.patchDraft(dto);
        return ClaimDTO.fromEntity(claimService.save(draftToPatch));
    }

    @PatchMapping("/send")
    public ClaimDTO send(@RequestParam int userId, @RequestParam int id) {
        Claim claimToSend = claimService.findById(id);
        if (claimToSend.getUser().getId() == userId && claimToSend.getStatus().equals(ClaimStatus.ЧЕРНОВИК)) {
            claimToSend.send();
            return ClaimDTO.fromEntity(claimService.save(claimToSend));
        }
        return null;
    }


}
