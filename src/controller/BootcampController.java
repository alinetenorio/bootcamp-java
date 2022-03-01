package controller;

import dados.BootcampRepository;
import dominio.Bootcamp;

public class BootcampController {
  BootcampRepository bootcampRepository = new BootcampRepository();

  public void criar() {

  }

  public void editar() {

  }

  public void deletar() {

  }

  public Bootcamp listar(String nomeBootcamp) {
    return bootcampRepository.listar(nomeBootcamp);
  }

  public void listarTodos() {

  }
}
