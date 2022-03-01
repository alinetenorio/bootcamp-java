package dominio;

import util.EspecialidadeEnum;

public class Especialista extends Pessoa {
  private String cargo;
  private EspecialidadeEnum especialidade;

  public Especialista(String nome, String email, String cargo, EspecialidadeEnum especialidade) {
    super(nome, email);
    this.cargo = cargo;
    this.especialidade = especialidade;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public EspecialidadeEnum getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(EspecialidadeEnum especialidade) {
    this.especialidade = especialidade;
  }

  @Override
  public String toString() {
    return "Nome: " + this.getNome() + "\nEmail: " + this.getEmail() +  "\nCargo: " + this.getCargo() +
        "\nEspecialidade: " + this.getEspecialidade();
  }
}
