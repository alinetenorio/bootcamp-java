package bootcamp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONException;

import bootcamp.dados.DevRepository;
import bootcamp.dominio.pessoa.Dev;
import bootcamp.service.DevService;

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
  
  public void criar(String nome, String email) throws IllegalAccessException, IllegalArgumentException, 
                                                      InvocationTargetException, IOException, JSONException {
    Dev dev = new Dev(nome, email);
    devRepository.criar(dev);
  }

  public void editar(String nome, String email) {
    devRepository.editarNome(nome, email);
  }

  public void deletar(String email) {
    devRepository.deletar(email);
  }

  public Dev listar(String emailDev) {
    return devRepository.listar(emailDev);
  }

  public List<Dev> listarTodos() {
    return devRepository.listarTodos();
  }

}
