package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.pessoa.Dev;

public class DevRepository {
  private final List<Dev> listaDevs = new ArrayList<>();

  public void criar(Dev dev) {

  }

  public void editar(String nome) {

  }

  public void deletar(String email) {

  }

  public Dev listar(String emailDev) {
    for(Dev d : listaDevs) {
      if( d.getEmail().equals(emailDev) ) return d;
    }
    return null;
  }

  public List<Dev> listarTodos() {
    return this.listaDevs;
  }
}