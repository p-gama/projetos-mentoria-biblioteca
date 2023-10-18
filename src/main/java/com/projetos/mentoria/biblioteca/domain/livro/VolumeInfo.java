package com.projetos.mentoria.biblioteca.domain.livro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.OrderColumn;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VolumeInfo {
    private String title;
    @ElementCollection
    @OrderColumn
    private String[] authors;
    @Column(length = 5000)
    private String description;

}