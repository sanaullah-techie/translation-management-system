package com.digitaltolk.translation.service;

import com.digitaltolk.translation.dto.TranslationDTO;

import java.util.List;

public interface TranslationService {

    TranslationDTO saveTranslation(TranslationDTO dto);
    List<TranslationDTO> searchByKey(String key);
    List<TranslationDTO> searchByLocale(String locale);
    List<TranslationDTO> searchByTag(String tag);
}
