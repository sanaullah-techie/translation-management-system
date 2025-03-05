package com.digitaltolk.translation.service.impl;

import com.digitaltolk.translation.dto.TranslationDTO;
import com.digitaltolk.translation.entity.Translation;
import com.digitaltolk.translation.repository.TranslationRepository;
import com.digitaltolk.translation.service.TranslationService;
import com.digitaltolk.translation.util.TranslationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final TranslationRepository translationRepository;

    public TranslationDTO saveTranslation(TranslationDTO dto) {
        Translation translation = TranslationMapper.toEntity(dto);
        Translation savedTranslation = translationRepository.save(translation);
        return TranslationMapper.toDTO(savedTranslation);
    }

    public List<TranslationDTO> searchByKey(String key) {
        return translationRepository.findByKeyContainingIgnoreCase(key)
                .stream()
                .map(TranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TranslationDTO> searchByLocale(String locale) {
        return translationRepository.findByLocale(locale)
                .stream()
                .map(TranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TranslationDTO> searchByTag(String tag) {
        return translationRepository.findByTagsContaining(tag)
                .stream()
                .map(TranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

}
