package dio.avanade.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Link> links;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
