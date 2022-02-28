package dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
  private String nome;
  private String email;
  private double xpTotal;
  private int nivel;
  private Set<Bootcamp> bootcampsInscritos;
  private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<>();
  
  public Dev( String nome, String email ) {
    this.nome = nome;
    this.email = email;
    this.xpTotal = 0;
    this.bootcampsInscritos =  new LinkedHashSet<>();
    this.bootcampsConcluidos =  new LinkedHashSet<>();
  }
  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
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

  @Override
  public String toString() {
    return "Nome: " + nome + "\nEmail: " + email + "\nNível: " + nivel + "\nXP: " + xpTotal;
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
