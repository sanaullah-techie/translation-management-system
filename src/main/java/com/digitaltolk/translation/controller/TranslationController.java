package com.digitaltolk.translation.controller;

import com.digitaltolk.translation.dto.TranslationDTO;
import com.digitaltolk.translation.service.TranslationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
@Tag(name = "Translations", description = "Endpoints for managing translations")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService service;

    @Operation(summary = "Create a new translation", description = "Creates and saves a new translation entry.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created translation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    @PostMapping
    public ResponseEntity<TranslationDTO> createTranslation(@Valid @RequestBody TranslationDTO dto) {
        return ResponseEntity.ok(service.saveTranslation(dto));
    }

    @Operation(summary = "Search translations by key", description = "Find translations matching a specific key.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved translations"),
            @ApiResponse(responseCode = "404", description = "Translations not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    @GetMapping("/search/key/{key}")
    public ResponseEntity<List<TranslationDTO>> searchByKey(
            @Parameter(description = "Key to search translations by") @Valid @PathVariable("key") String key) {
        return ResponseEntity.ok(service.searchByKey(key));
    }

    @Operation(summary = "Search translations by locale", description = "Find translations for a specific locale.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved translations"),
            @ApiResponse(responseCode = "404", description = "Translations not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    @GetMapping("/search/locale/{locale}")
    public ResponseEntity<List<TranslationDTO>> searchByLocale(
            @Parameter(description = "Locale to search translations by") @Valid @PathVariable("locale") String locale) {
        return ResponseEntity.ok(service.searchByLocale(locale));
    }

    @Operation(summary = "Search translations by tag", description = "Find translations associated with a specific tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved translations"),
            @ApiResponse(responseCode = "404", description = "Translations not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    @GetMapping("/search/tag/{tag}")
    public ResponseEntity<List<TranslationDTO>> searchByTag(
            @Parameter(description = "Tag to search translations by") @Valid @PathVariable("tag") String tag) {
        return ResponseEntity.ok(service.searchByTag(tag));
    }
}
