package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.pessoa.Especialista;

public class EspecialistaRepository {
  private final List<Especialista> listaEspecialistas = new ArrayList<>();
  private final Arquivo<Especialista> arquivo = new Arquivo<>();

  public void criar(Especialista especialista) throws IllegalAccessException, IllegalArgumentException, 
                                                      InvocationTargetException, IOException, JSONException {
    listaEspecialistas.add(especialista);
    arquivo.criar(especialista);
  }

  public void editarNome(String nomeNovo, String email) {
    Especialista atual = listar(email);
    listaEspecialistas.get(listaEspecialistas.indexOf(atual)).setNome(nomeNovo);    
  }

  public void deletar(String email) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    Especialista atual = listar(email);
    listaEspecialistas.remove(atual);
    arquivo.deletar(atual);
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