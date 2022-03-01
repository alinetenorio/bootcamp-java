package dominio.conteudo;

import dominio.pessoa.Especialista;

public class Curso extends Conteudo{

  private int cargaHoraria;

  public Curso(String titulo, String descricao, Especialista especialista, int cargaHoraria) {
    super(titulo, descricao, especialista);    
    this.cargaHoraria = cargaHoraria;
  }

  @Override
  public double calcularXp() {
    return XP_PADRAO * cargaHoraria;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
      this.cargaHoraria = cargaHoraria;
  }

  @Override
  public String toString() {
      return "Título: " + getTitulo() +
              "\nDescrição: " + getDescricao() +
              "\nCarga horária: " + cargaHoraria;
  }
  
}
