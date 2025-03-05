package com.digitaltolk.translation.repository;

import com.digitaltolk.translation.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {

    @Query("SELECT t FROM Translation t WHERE LOWER(t.key) LIKE LOWER(CONCAT('%', :key, '%')) ORDER BY t.updatedAt DESC")
    List<Translation> findByKeyContainingIgnoreCase(@Param("key") String key);

    @Query("SELECT t FROM Translation t WHERE t.locale = :locale ORDER BY t.updatedAt DESC")
    List<Translation> findByLocale(@Param("locale") String locale);

    @Query("SELECT t FROM Translation t JOIN t.tags tag WHERE tag = :tag ORDER BY t.updatedAt DESC")
    List<Translation> findByTagsContaining(@Param("tag") String tag);

}
