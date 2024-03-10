package org.klozevitz.lightdigital.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lightdigital.dao.serviceInterfaces.RoleService;
import org.klozevitz.lightdigital.dao.serviceInterfaces.UserService;
import org.klozevitz.lightdigital.dao.serviceInterfaces.ClaimService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c")
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;
    private final RoleService roleService;
    private final ClaimService claimService;

    @GetMapping
    public String ping() {
        System.out.println();
        userService.all().forEach(u -> u.getClaims().forEach(System.out::println));
        System.out.println("***\n***\n");
        userService.all().forEach(System.out::println);
        return "0";
    }
}
