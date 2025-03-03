package com.digitaltolk.translation.util;

import com.digitaltolk.translation.dto.TranslationDTO;
import com.digitaltolk.translation.entity.Translation;

public class TranslationMapper {

    public static TranslationDTO toDTO(Translation translation) {
        return new TranslationDTO(translation.getKey(), translation.getLocale(), translation.getContent(), translation.getTags());
}

    public static Translation toEntity(TranslationDTO dto) {
        return Translation.builder()
                .key(dto.key())
                .locale(dto.locale())
                .content(dto.content())
                .tags(dto.tags())
                .build();
    }

}
