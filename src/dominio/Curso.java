package dominio;

public class Curso extends Conteudo{

  private int cargaHoraria;

  public Curso(String titulo, String descricao, Especialista especialista) {
    super(titulo, descricao, especialista);    
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
              "Carga horária: " + cargaHoraria;
  }
  
}
