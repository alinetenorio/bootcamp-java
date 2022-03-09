package bootcamp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONException;

import bootcamp.dados.CursoRepository;
import bootcamp.dominio.conteudo.Curso;
import bootcamp.dominio.pessoa.Especialista;

public class CursoController {
  CursoRepository cursoRepository = new CursoRepository();

  public void criar(String titulo, String descricao, Especialista especialista, int cargaHoraria) 
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, JSONException {
    Curso Curso = new Curso(titulo, descricao, especialista, cargaHoraria);
    cursoRepository.criar(Curso);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    cursoRepository.editarDescricao(titulo, novaDescricao);
  }

  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    cursoRepository.editarEspecialista(titulo, novoEspecialista);
  }

  public void editarCargaHoraria(String titulo, int novaCargaHoraria) {
    cursoRepository.editarCargaHoraria(titulo, novaCargaHoraria);
  }

  public void deletar(String nome) throws IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException, IOException {
    cursoRepository.deletar(nome);
  }

  public Curso listar(String nome) {
    return cursoRepository.listar(nome);
  }

  public List<Curso> listarTodos() {
    return cursoRepository.listarTodos();
  }
}
