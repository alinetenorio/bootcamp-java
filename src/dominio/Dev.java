package dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev extends Pessoa {  
  private double xpTotal;
  private int nivel;
  private Set<Bootcamp> bootcampsInscritos;
  private Set<Bootcamp> bootcampsConcluidos;
  private Set<Progresso> progressos;
  
  public Dev(String nome, String email) {
    super(nome, email);
    this.xpTotal = 0;
    this.bootcampsInscritos =  new LinkedHashSet<>();
    this.bootcampsConcluidos =  new LinkedHashSet<>();
    this.progressos =  new LinkedHashSet<>();
  }
 
  public double getXpTotal() {
    return xpTotal;
  }
  public void setXpTotal(double xpTotal) {
    this.xpTotal = xpTotal;
  }
  public int getNivel() {
    return nivel;
  }
  public void setNivel(int nivel) {
    this.nivel = nivel;
  }
  public Set<Bootcamp> getBootcampsInscritos() {
    return bootcampsInscritos;
  }  
  public Set<Bootcamp> getBootcampsConcluidos() {
    return bootcampsConcluidos;
  }
  public Set<Progresso> getProgressos() {
    return progressos;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Dev dev = (Dev) o;
      return Objects.equals(this.getNome(), dev.getNome()) && 
              Objects.equals(this.getEmail(), dev.getEmail()) &&
              Objects.equals(this.getBootcampsInscritos(), dev.getBootcampsInscritos()) && 
              Objects.equals(this.getBootcampsConcluidos(), dev.getBootcampsConcluidos());
  }

  @Override
  public int hashCode() {
      return Objects.hash(this.getNome(), this.getEmail(), this.getBootcampsInscritos(), this.getBootcampsConcluidos());
  }

  @Override
  public String toString() {
    return "Nome: " + this.getNome() + "\nEmail: " + this.getEmail() + "\nNível: " + this.getNivel() + "\nXP: " + this.getXpTotal();
  }

  public String listarBootcampsInscritos() {
    String res = "";    
    for( Bootcamp b : this.getBootcampsInscritos() ) {
      res += b.toString();
    }
    return res;
  }
 
  public String listarBootcampsConcluidos() {
    String res = "";    
    for( Bootcamp b : this.getBootcampsConcluidos() ) {
      res += b.toString();
    }
    return res;
  }
}
