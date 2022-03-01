package dominio.conteudo;

import dominio.pessoa.Especialista;

public abstract class Conteudo {
  protected static final double XP_PADRAO = 10d;

  private String titulo;
  private String descricao;
  private Especialista especialista;

  public Conteudo(String titulo, String descricao, Especialista especialista){
    this.titulo = titulo;
    this.descricao = descricao;
    this.especialista = especialista;
  };

  public abstract double calcularXp();

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

  public Especialista getEspecialista() {
    return especialista;
  }

  public void setEspecialista(Especialista especialista) {
    this.especialista = especialista;
  }
  
}