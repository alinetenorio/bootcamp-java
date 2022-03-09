package bootcamp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONException;

import bootcamp.dados.BootcampRepository;
import bootcamp.dominio.Bootcamp;

public class BootcampController {
  BootcampRepository bootcampRepository = new BootcampRepository();

  public void criar(String nome, String descricao) throws IOException, Exception{
    Bootcamp bootcamp = new Bootcamp(nome, descricao);
    bootcampRepository.criar(bootcamp);
  }

  public void editar(String nome, String descricao) {
    bootcampRepository.editarDescricao(nome, descricao);
  }

  public void deletar(String nome) throws IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException, IOException {
    bootcampRepository.deletar(nome);
  }

  public Bootcamp listar(String nome) {
    return bootcampRepository.listar(nome);
  }

  public List<Bootcamp> listarTodos() {
    return bootcampRepository.listarTodos();
  }
  
}
