package bootcamp.dados;

import java.util.ArrayList;
import java.util.List;

import bootcamp.dominio.Progresso;

public class ProgressoRepository {
  private final List<Progresso> listaProgressos = new ArrayList<>();

  public void criar(Progresso p) {
    listaProgressos.add(p);
  }

  public void deletar(String emailDev, String nomeBootcamp) {
    Progresso atual = listar(emailDev, nomeBootcamp);
    listaProgressos.remove(atual);
  }

  public Progresso listar(String emailDev, String nomeBootcamp) {
    for(Progresso p : listaProgressos) {
      if( p.getDev().getEmail().equals(emailDev) &&
          p.getBootcamp().getNome().equals(nomeBootcamp)) return p;
    }
    return null;
  }

  public List<Progresso> listarTodos() {
    return this.listaProgressos;
  }
}