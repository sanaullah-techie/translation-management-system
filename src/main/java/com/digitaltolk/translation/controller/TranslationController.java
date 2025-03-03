package com.digitaltolk.translation.controller;

import com.digitaltolk.translation.dto.TranslationDTO;
import com.digitaltolk.translation.service.TranslationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService service;

    @PostMapping
    public ResponseEntity<TranslationDTO> createTranslation(@Valid @RequestBody TranslationDTO dto) {
        return ResponseEntity.ok(service.saveTranslation(dto));
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<List<TranslationDTO>> searchByKey(@Valid  @PathVariable("key") String key){

        return ResponseEntity.ok(service.searchByKey(key));
    }

    @GetMapping("/search/{locale}")
    public ResponseEntity<List<TranslationDTO>> searchByLocale(@Valid @PathVariable("locale") String locale){

        return ResponseEntity.ok(service.searchByLocale(locale));
    }

    @GetMapping("/search/{tag}")
    public ResponseEntity<List<TranslationDTO>> searchByTag(@Valid @PathVariable("tag") String tag){

       return ResponseEntity.ok(service.searchByTag(tag));

    }

}
