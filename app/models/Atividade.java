package models;

import javax.persistence.*;

/**
 * Created by caio on 25/03/15.
 */
@Entity
@Table(name = "ATIVIDADE")
public class Atividade {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtividade;
    @Column
    private String titulo;
    @Column
    private String descricao;

    public Atividade(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Atividade(){

    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
