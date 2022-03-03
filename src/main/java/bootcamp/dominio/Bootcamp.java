package bootcamp.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import bootcamp.dominio.conteudo.Conteudo;
import bootcamp.dominio.pessoa.Dev;

public class Bootcamp {
  private String nome;
  private String descricao;
  private final LocalDate dataInicial;
  private final LocalDate dataFinal;
  private Set<Dev> devsInscritos;
  private Set<Conteudo> conteudos;

  public Bootcamp( String nome, String descricao ) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataInicial = LocalDate.now();  
    this.dataFinal = dataInicial.plusDays(45);  
    this.devsInscritos = new HashSet<>();
    this.conteudos = new LinkedHashSet<>();
  }

  public Bootcamp( String nome, String descricao, LocalDate dataFinal ) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataInicial = LocalDate.now();
    this.dataFinal = dataFinal;
    this.devsInscritos = new HashSet<>();
    this.conteudos = new LinkedHashSet<>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataInicial() {
    return dataInicial;
  }

  public LocalDate getDataFinal() {
    return dataFinal;
  }

  public Set<Dev> getDevsInscritos() {
    return devsInscritos;
  }

  public Set<Conteudo> getConteudos() {
    return conteudos;
  }

  public void setConteudos(Set<Conteudo> conteudos) {
    this.conteudos = conteudos;
  }

  @Override
  public String toString() {
    return "Nome: " + nome + "\nDescrição: " + descricao +  "\nData inicial: " + dataInicial +
        "\nData final: " + dataFinal;
  }
  
  public String listarDevsInscritos() {
    String res = "";    
    for( Dev d : this.getDevsInscritos() ) {
      res += d.toString();
    }
    return res;
  }

  public String listarConteudos() {
    String res = "";    
    for( Conteudo c : this.getConteudos() ) {
      res += c.toString();
    }
    return res;
  }
  
}