package com.digitaltolk.translation;

import com.digitaltolk.translation.dto.TranslationDTO;
import com.digitaltolk.translation.entity.Translation;
import com.digitaltolk.translation.repository.TranslationRepository;
import com.digitaltolk.translation.service.impl.TranslationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TranslationServiceTest {

    @Mock
    private TranslationRepository translationRepository;

    @InjectMocks
    private TranslationServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(TranslationServiceTest.class);
    }

    @Test
    void testSaveTranslation() {
        // Arrange
        Translation translation = new Translation();
        translation.setKey("greeting");
        translation.setLocale("en");
        translation.setContent("Hello");

        when(translationRepository.save(ArgumentMatchers.<Translation>any())).thenReturn(translation);

        // Act
        Translation savedTranslation = translationRepository.save(new Translation());

        // Assert
        assertNotNull(savedTranslation);
        assertEquals("greeting", savedTranslation.getKey());
  }

    @Test
    void testSearchByKey() {
        Translation translation = new Translation(1L, "hello", "en", "Hello", Set.of("greeting"), null, null);
        when(translationRepository.findByKeyContainingIgnoreCase("hello")).thenReturn(Arrays.asList(translation));
        List<TranslationDTO> result = service.searchByKey("hello");
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("hello", result.getFirst().key());
    }

    @Test
    void testSearchByLocale() {
        Translation translation = new Translation(1L, "hello", "fr", "Bonjour", Set.of("greeting"), null, null);
        when(translationRepository.findByLocale("fr")).thenReturn(List.of(translation));

        List<TranslationDTO> result = service.searchByLocale("fr");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("fr", result.get(0).locale());
 }

    @Test
    void testSearchByTag() {
        Translation translation = new Translation(1L, "hello", "en", "Hello", Set.of("greeting"), null, null);
        when(translationRepository.findByTagsContaining("greeting")).thenReturn(List.of(translation));

        List<TranslationDTO> result = service.searchByTag("greeting");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("greeting", result.getFirst().tags().stream().toList().getFirst());
    }

}
