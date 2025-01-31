package com.JTWTemplateProject.controllers;

import com.JTWTemplateProject.dto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/@me")
public class SelfController {

    @GetMapping
    public ResponseEntity<UserResponseDto> getUser() {
        // Retrieve the current authentication from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // If no user is authenticated, return a 401 Unauthorized response.
        if (authentication == null || !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Extract the username from the principal. Depending on your setup,
        // the principal may be an instance of UserDetails or just a plain string.
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            username = ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        // Build the response DTO.
        UserResponseDto userResponse = new UserResponseDto(username);
        return ResponseEntity.ok(userResponse);
    }
}
