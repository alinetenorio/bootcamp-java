package controller;

import dados.DevRepository;
import dominio.Bootcamp;
import dominio.pessoa.Dev;
import service.DevService;

public class DevController {
  DevService devService = new DevService();
  DevRepository devRepository = new DevRepository();
  BootcampController bootcampController = new BootcampController();
  
  public void inscreverEmBootcamp(String emailDev, String nomeBootcamp) {
    devService.inscreverEmBootcamp(listar(emailDev), bootcampController.listar(nomeBootcamp));
  }

  public void progredir(String emailDev, String nomeBootcamp) {
    devService.progredir(listar(emailDev), bootcampController.listar(nomeBootcamp));
  }
  
  public void criar() {
    devRepository.criar();
  }

  public void editar() {

  }

  public void deletar() {

  }

  public Dev listar(String emailDev) {
    return devRepository.listar(emailDev);
  }

  public void listarTodos() {

  }

}
