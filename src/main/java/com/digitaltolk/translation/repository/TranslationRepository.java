package com.digitaltolk.translation.repository;

import com.digitaltolk.translation.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {

    List<Translation> findByKeyContainingIgnoreCase(String key);
    List<Translation> findByLocale(String locale);
    List<Translation> findByTagsContaining(String tag);

}
