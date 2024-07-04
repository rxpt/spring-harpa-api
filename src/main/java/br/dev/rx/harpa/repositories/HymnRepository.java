package br.dev.rx.harpa.repositories;

import br.dev.rx.harpa.models.Hymn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HymnRepository extends MongoRepository<Hymn, String> {

    Hymn findByNumber(Integer number);

    @Query("{ $expr: { $regexMatch: { input: { $toString: '$number' }, regex: ?0, options: 'i' } } }")
    Page<Hymn> findByNumberRegex(String number, Pageable pageable);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    Page<Hymn> findByTitleRegex(String title, Pageable pageable);

    @Query("{ 'verses.lyrics': { $regex: ?0, $options: 'i' } }")
    Page<Hymn> findByVersesLyricsRegex(String verse, Pageable pageable);
}
