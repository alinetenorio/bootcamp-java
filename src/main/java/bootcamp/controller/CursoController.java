package bootcamp.controller;

import java.util.List;

import bootcamp.dados.CursoRepository;
import bootcamp.dominio.conteudo.Curso;
import bootcamp.dominio.pessoa.Especialista;

public class CursoController {
  CursoRepository CursoRepository = new CursoRepository();

  public void criar(String titulo, String descricao, Especialista especialista, int cargaHoraria) {
    Curso Curso = new Curso(titulo, descricao, especialista, cargaHoraria);
    CursoRepository.criar(Curso);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    CursoRepository.editarDescricao(titulo, novaDescricao);
  }

  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    CursoRepository.editarEspecialista(titulo, novoEspecialista);
  }

  public void editarCargaHoraria(String titulo, int novaCargaHoraria) {
    CursoRepository.editarCargaHoraria(titulo, novaCargaHoraria);
  }

  public void deletar(String nome) {
    CursoRepository.deletar(nome);
  }

  public Curso listar(String nome) {
    return CursoRepository.listar(nome);
  }

  public List<Curso> listarTodos() {
    return CursoRepository.listarTodos();
  }
}
