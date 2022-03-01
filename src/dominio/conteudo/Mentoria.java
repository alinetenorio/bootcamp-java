package dominio.conteudo;

import java.time.LocalDate;

import dominio.pessoa.Especialista;

public class Mentoria extends Conteudo {
  private LocalDate data;

  @Override
  public double calcularXp() {
      return XP_PADRAO + 20d;
  }

  public Mentoria(String titulo, String descricao, Especialista especialista, LocalDate data) {
    super(titulo, descricao, especialista);
    this.data = data;
  }

  public LocalDate getData() {
      return data;
  }

  public void setData(LocalDate data) {
      this.data = data;
  }

  @Override
  public String toString() {
      return "Título: " + getTitulo() +
              "\nDescrição: " + getDescricao() +
              "\nData: " + data;
  }
}
