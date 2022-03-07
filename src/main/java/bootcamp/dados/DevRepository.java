package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.pessoa.Dev;

public class DevRepository {
  private final List<Dev> listaDevs = new ArrayList<>();
  private final Arquivo<Dev> arquivo = new Arquivo<>();

  public void criar(Dev dev) throws IllegalAccessException, IllegalArgumentException, 
                                    InvocationTargetException, IOException, JSONException {
    listaDevs.add(dev);
    arquivo.criar(dev);
  }

  public void editarNome(String nomeNovo, String email) {
    Dev atual = listar(email);
    listaDevs.get(listaDevs.indexOf(atual)).setNome(nomeNovo);    
  }

  public void deletar(String email) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    Dev atual = listar(email);
    listaDevs.remove(atual);
    arquivo.deletar(atual);
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