package br.dev.rx.harpa.services;

import br.dev.rx.harpa.models.Hymn;
import br.dev.rx.harpa.repositories.HymnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HymnService {

    @Autowired
    private HymnRepository hymnRepository;

    public Page<Hymn> listHymns(int page, int limit) {
        return hymnRepository.findAll(PageRequest.of(page - 1, limit));
    }

    public Optional<Hymn> getHymnDetails(int number) {
        return Optional.ofNullable(hymnRepository.findByNumber(number));
    }

    public Page<Hymn> searchHymnsByNumber(String number, int page, int limit) {
        return hymnRepository.findByNumberRegex(number, PageRequest.of(page - 1, limit));
    }

    public Page<Hymn> searchHymnsByTitle(String title, int page, int limit) {
        return hymnRepository.findByTitleRegex(".*" + title + ".*", PageRequest.of(page - 1, limit));
    }

    public Page<Hymn> searchHymnsByVerse(String verse, int page, int limit) {
        return hymnRepository.findByVersesLyricsRegex(".*" + verse + ".*", PageRequest.of(page - 1, limit));
    }

    public Hymn getRandomHymn() {
        long count = hymnRepository.count();
        int random = ThreadLocalRandom.current().nextInt((int) count);
        return hymnRepository.findAll(PageRequest.of(random, 1)).getContent().get(0);
    }
}