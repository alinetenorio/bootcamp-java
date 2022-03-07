package bootcamp.dados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import bootcamp.dominio.conteudo.Curso;
import bootcamp.dominio.pessoa.Especialista;

public class CursoRepository {
  private final List<Curso> listaCursos = new ArrayList<>();
  private final Arquivo<Curso> arquivo = new Arquivo<>();

  public void criar(Curso c) throws IOException, IllegalAccessException, IllegalArgumentException, 
                                    InvocationTargetException, JSONException {
    listaCursos.add(c);
    arquivo.criar(c);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    Curso atual = listar(titulo);
    listaCursos.get(listaCursos.indexOf(atual)).setDescricao(novaDescricao);    
  }

  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    Curso atual = listar(titulo);
    listaCursos.get(listaCursos.indexOf(atual)).setEspecialista(novoEspecialista);    
  }

  public void editarCargaHoraria(String titulo, int novaCargaHoraria) {
    Curso atual = listar(titulo);
    listaCursos.get(listaCursos.indexOf(atual)).setCargaHoraria(novaCargaHoraria);    
  }

  public void deletar(String titulo) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    Curso atual = listar(titulo);
    listaCursos.remove(atual);
    arquivo.deletar(atual);
  }

  public Curso listar(String titulo) {
    for(Curso c : listaCursos) {
      if( c.getTitulo().equals(titulo) ) return c;
    }
    return null;
  }

  public List<Curso> listarTodos() {
    return this.listaCursos;
  }
}