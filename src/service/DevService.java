package service;

import java.util.Optional;

import dominio.Bootcamp;
import dominio.Dev;
import dominio.Progresso;

public class DevService {
  
  public void inscreverDevBootcamp(Dev dev, Bootcamp bootcamp){
    dev.getBootcampsInscritos().add(bootcamp);
    dev.getProgressos().add(new Progresso(dev, bootcamp));
    
    bootcamp.getDevsInscritos().add(dev);
  }

  public void progredir(Dev dev, Bootcamp bootcamp) {
    
    for(Progresso p : dev.getProgressos() ) {
      if(p.getBootcamp().equals(bootcamp)) {
        bootcamp.getConteudos()
          .stream()
          .forEach(conteudo -> {
            if( p.getConteudosConcluidos().contains(conteudo) ) {
              p.getConteudosConcluidos().add(conteudo);
              dev.setXpTotal(dev.getXpTotal() + conteudo.calcularXp());
            }
          });
        
        break;
      }
    }
    

  
  }
}
