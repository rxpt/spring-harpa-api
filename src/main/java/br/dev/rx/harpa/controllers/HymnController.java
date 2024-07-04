package br.dev.rx.harpa.controllers;

import br.dev.rx.harpa.dto.HymnSummary;
import br.dev.rx.harpa.exceptions.ResourceNotFoundException;
import br.dev.rx.harpa.models.Hymn;
import br.dev.rx.harpa.services.HymnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hymns")
public class HymnController {

    @Autowired
    private HymnService hymnService;

    @GetMapping
    public Page<HymnSummary> listHymns(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit) {
        Page<Hymn> hymnPage = hymnService.listHymns(page, limit);
        return hymnPage.map(hymn -> new HymnSummary(hymn.getNumber(), hymn.getTitle()));
    }

    @GetMapping("/search/number/{number}")
    public Page<HymnSummary> searchHymnsByNumber(@PathVariable String number,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int limit) {
        Page<Hymn> hymnPage = hymnService.searchHymnsByNumber(number, page, limit);
        return hymnPage.map(hymn -> new HymnSummary(hymn.getNumber(), hymn.getTitle()));
    }

    @GetMapping("/search/title/{title}")
    public Page<HymnSummary> searchHymnsByTitle(@PathVariable String title,
                                         @RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int limit) {
        Page<Hymn> hymnPage = hymnService.searchHymnsByTitle(title, page, limit);
        return hymnPage.map(hymn -> new HymnSummary(hymn.getNumber(), hymn.getTitle()));
    }

    @GetMapping("/search/verse/{verse}")
    public Page<HymnSummary> searchHymnsByVerse(@PathVariable String verse,
                                         @RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int limit) {
        Page<Hymn> hymnPage = hymnService.searchHymnsByVerse(verse, page, limit);
        return hymnPage.map(hymn -> new HymnSummary(hymn.getNumber(), hymn.getTitle()));
    }

    @GetMapping("/random")
    public Hymn getRandomHymn() {
        return hymnService.getRandomHymn();
    }

    @GetMapping("/{number}")
    public Hymn getHymnDetails(@PathVariable int number) {
        return hymnService.getHymnDetails(number)
                .orElseThrow(() -> new ResourceNotFoundException("Hino não encontrado"));
    }
}