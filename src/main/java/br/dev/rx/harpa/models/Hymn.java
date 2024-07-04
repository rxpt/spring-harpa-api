package br.dev.rx.harpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "hinos")
@CompoundIndex(def = "{'number': 1}", unique = true)
@CompoundIndex(def = "{'title': 'text'}")
@CompoundIndex(def = "{'verses.lyrics': 'text'}")
@Getter
@Setter
@AllArgsConstructor
public class Hymn {

    @Id
    @Field("_id")
    private String id;

    @Field("number")
    private Integer number;

    @Field("title")
    @TextIndexed
    private String title;

    @Field("verses")
    private List<Verse> verses;
}

