package com.JTWTemplateProject.dto;

public record AuthResponseDto(
        String token,
        String refreshToken,
        String expiresIn
) {}
