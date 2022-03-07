package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.conteudo.Mentoria;
import bootcamp.dominio.pessoa.Especialista;

public class MentoriaRepository {
  private final List<Mentoria> listaMentorias = new ArrayList<>();
  private final Arquivo<Mentoria> arquivo = new Arquivo<>();

  public void criar(Mentoria m) throws IllegalAccessException, IllegalArgumentException, 
                                        InvocationTargetException, IOException, JSONException {
    listaMentorias.add(m);
    arquivo.criar(m);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setDescricao(novaDescricao);    
  }

  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setEspecialista(novoEspecialista);    
  }

  public void editarData(String titulo, LocalDate novaData) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setData(novaData);    
  }

  public void deletar(String titulo) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    Mentoria atual = listar(titulo);
    listaMentorias.remove(atual);
    arquivo.deletar(atual);
  }

  public Mentoria listar(String titulo) {
    for(Mentoria c : listaMentorias) {
      if( c.getTitulo().equals(titulo) ) return c;
    }
    return null;
  }

  public List<Mentoria> listarTodos() {
    return this.listaMentorias;
  }
}