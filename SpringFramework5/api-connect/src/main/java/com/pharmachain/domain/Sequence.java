package com.pharmachain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "sequence")
@Getter
@Setter
public class Sequence {
    @Id
    private String id;
    private long seq;
}
