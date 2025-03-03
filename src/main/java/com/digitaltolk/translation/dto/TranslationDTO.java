package com.digitaltolk.translation.dto;

import java.util.Set;

public record TranslationDTO(String key, String locale, String content, Set<String> tags){}
