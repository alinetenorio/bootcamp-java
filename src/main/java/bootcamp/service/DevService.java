package bootcamp.service;

import bootcamp.dominio.Bootcamp;
import bootcamp.dominio.Progresso;
import bootcamp.dominio.conteudo.Conteudo;
import bootcamp.dominio.pessoa.Dev;

public class DevService {
  
  public void inscreverEmBootcamp(Dev dev, Bootcamp bootcamp){
    dev.getBootcampsInscritos().add(bootcamp);
    dev.getProgressos().put(bootcamp.getNome(), new Progresso(dev, bootcamp));
    
    bootcamp.getDevsInscritos().add(dev);
  }

  public void progredir(Dev dev, Bootcamp bootcamp) {
    Progresso progresso = dev.getProgressos().get(bootcamp.getNome());
    
    for(Conteudo c : bootcamp.getConteudos()) {
      if(!progresso.getConteudosConcluidos().contains(c)) {
        progresso.getConteudosConcluidos().add(c);        
        progresso.adicionarXp(c.calcularXp());        
        break;
      }
    }  
    
    if(progresso.getConteudosConcluidos().size() == bootcamp.getConteudos().size()) {
      dev.getBootcampsConcluidos().add(bootcamp);
    }
  }

}
