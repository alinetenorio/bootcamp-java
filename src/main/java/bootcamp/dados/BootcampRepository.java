package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.Bootcamp;

public class BootcampRepository {
  private static final List<Bootcamp> listaBootcamps = new ArrayList<>();
  private final Arquivo<Bootcamp> arquivo;

  public BootcampRepository() {
    arquivo = new Arquivo<>();
  }

  public void criar(Bootcamp b) throws IOException, Exception{
    listaBootcamps.add(b);
    arquivo.criar(b);
  }

  public void editarDescricao(String nome, String novaDescricao) {
    Bootcamp atual = listar(nome);
    listaBootcamps.get(listaBootcamps.indexOf(atual)).setDescricao(novaDescricao);    
  }

  public void deletar(String nome) throws IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException, IOException {
    Bootcamp atual = listar(nome);
    listaBootcamps.remove(atual);
    arquivo.deletar(atual);
  }

  public Bootcamp listar(String nome) {
    for(Bootcamp b : listaBootcamps) {
      if( b.getNome().equals(nome) ) return b;
    }
    return null;
  }

  public List<Bootcamp> listarTodos() {
    return this.listaBootcamps;
  }

}