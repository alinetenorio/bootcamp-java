package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.conteudo.Curso;
import dominio.pessoa.Especialista;

public class CursoRepository {
  private final List<Curso> listaCursos = new ArrayList<>();

  public void criar(Curso c) {
    listaCursos.add(c);
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

  public void deletar(String titulo) {
    Curso atual = listar(titulo);
    listaCursos.remove(atual);
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