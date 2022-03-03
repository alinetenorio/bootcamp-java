package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.pessoa.Dev;

public class DevRepository {
  private final List<Dev> listaDevs = new ArrayList<>();

  public void criar(Dev dev) {
    listaDevs.add(dev);
  }

  public void editarNome(String nomeNovo, String email) {
    Dev atual = listar(email);
    listaDevs.get(listaDevs.indexOf(atual)).setNome(nomeNovo);    
  }

  public void deletar(String email) {
    Dev atual = listar(email);
    listaDevs.remove(atual);
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