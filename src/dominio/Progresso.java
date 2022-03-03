package dominio;

import java.util.LinkedHashSet;
import java.util.Set;

import dominio.conteudo.Conteudo;
import dominio.pessoa.Dev;

public class Progresso {
  private final Dev dev;
  private final Bootcamp bootcamp;
  private final Set<Conteudo> conteudosConcluidos;
  private double xp;

  public Progresso(Dev dev, Bootcamp bootcamp) {
    this.dev = dev;
    this.bootcamp = bootcamp;
    this.conteudosConcluidos = new LinkedHashSet<>();
    this.xp = 0;
  }

  public Dev getDev() {
    return dev;
  }  
  public Bootcamp getBootcamp() {
    return bootcamp;
  }
  public Set<Conteudo> getConteudosConcluidos() {
    return conteudosConcluidos;
  }
  public double getXp() {
    return xp;
  }
  public void adicionarXp(double xp) {
    this.xp += xp;
    dev.adicionarXpTotal(xp);
  } 

}
