package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.Bootcamp;

public class BootcampRepository {
  private final List<Bootcamp> listaBootcamps = new ArrayList<>();

  public void criar() {

  }

  public void editar() {

  }

  public void deletar() {

  }

  public Bootcamp listar(String nome) {
    for(Bootcamp b : listaBootcamps) {
      if( b.getNome().equals(nome) ) return b;
    }
    return null;
  }

  public void listarTodos() {

  }
}