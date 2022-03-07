package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.Progresso;

public class ProgressoRepository {
  private final List<Progresso> listaProgressos = new ArrayList<>();
  private final Arquivo<Progresso> arquivo = new Arquivo<>();

  public void criar(Progresso p) throws IllegalAccessException, IllegalArgumentException, 
                                        InvocationTargetException, IOException, JSONException {
    listaProgressos.add(p);
    arquivo.criar(p);
  }

  public void deletar(String emailDev, String nomeBootcamp) throws IllegalAccessException, IllegalArgumentException,
                                                           InvocationTargetException, JSONException, IOException {
    Progresso atual = listar(emailDev, nomeBootcamp);
    listaProgressos.remove(atual);
    arquivo.deletar(atual);
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