package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.pessoa.Especialista;

public class EspecialistaRepository {
  private final List<Especialista> listaEspecialistas = new ArrayList<>();

  public void criar(Especialista especialista) {
    listaEspecialistas.add(especialista);
  }

  public void editarNome(String nomeNovo, String email) {
    Especialista atual = listar(email);
    listaEspecialistas.get(listaEspecialistas.indexOf(atual)).setNome(nomeNovo);    
  }

  public void deletar(String email) {
    Especialista atual = listar(email);
    listaEspecialistas.remove(atual);
  }

  public Especialista listar(String emailEspecialista) {
    for(Especialista d : listaEspecialistas) {
      if( d.getEmail().equals(emailEspecialista) ) return d;
    }
    return null;
  }

  public List<Especialista> listarTodos() {
    return this.listaEspecialistas;
  }
}