package br.dev.rx.harpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Verse {

    @Field("sequence")
    private Integer sequence;

    @Field("lyrics")
    private String lyrics;

    @Field("chorus")
    private boolean chorus;
}