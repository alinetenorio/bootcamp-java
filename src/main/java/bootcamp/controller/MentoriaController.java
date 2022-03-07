package bootcamp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;

import org.json.JSONException;

import bootcamp.dados.MentoriaRepository;
import bootcamp.dominio.conteudo.Mentoria;
import bootcamp.dominio.pessoa.Especialista;

public class MentoriaController {
  MentoriaRepository mentoriaRepository = new MentoriaRepository();

  public void criar(String titulo, String descricao, Especialista especialista, LocalDate data) throws 
          IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, JSONException {
    Mentoria Mentoria = new Mentoria(titulo, descricao, especialista, data);
    mentoriaRepository.criar(Mentoria);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    mentoriaRepository.editarDescricao(titulo, novaDescricao);
  }
  
  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    mentoriaRepository.editarEspecialista(titulo, novoEspecialista);
  }
  
  public void editarData(String titulo, LocalDate novaData) {
    mentoriaRepository.editarData(titulo, novaData);
  }

  public void deletar(String nome) throws IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException, IOException {
    mentoriaRepository.deletar(nome);
  }

  public Mentoria listar(String nome) {
    return mentoriaRepository.listar(nome);
  }

  public List<Mentoria> listarTodos() {
    return mentoriaRepository.listarTodos();
  }
}
