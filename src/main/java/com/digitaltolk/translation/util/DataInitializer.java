package com.digitaltolk.translation.util;

import com.digitaltolk.translation.entity.Translation;
import com.digitaltolk.translation.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final TranslationRepository translationRepository;

    @Override
    public void run(String... args) {
        if (translationRepository.count() == 0) {
            List<Translation> translations = List.of(
                    new Translation(null, "hello", "en", "Hello", Set.of("greeting"), null, null),
                    new Translation(null, "hola", "es", "Hola", Set.of("greeting"), null, null),
                    new Translation(null, "bonjour", "fr", "Bonjour", Set.of("greeting"), null, null),
                    new Translation(null, "hallo", "de", "Hallo", Set.of("greeting"), null, null),
                    new Translation(null, "ciao", "it", "Ciao", Set.of("greeting"), null, null)
            );

            translationRepository.saveAll(translations);
        }
    }
}
