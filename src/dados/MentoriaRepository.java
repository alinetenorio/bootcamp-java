package dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.conteudo.Mentoria;
import dominio.pessoa.Especialista;

public class MentoriaRepository {
  private final List<Mentoria> listaMentorias = new ArrayList<>();

  public void criar(Mentoria m) {
    listaMentorias.add(m);
  }

  public void editarDescricao(String titulo, String novaDescricao) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setDescricao(novaDescricao);    
  }

  public void editarEspecialista(String titulo, Especialista novoEspecialista) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setEspecialista(novoEspecialista);    
  }

  public void editarData(String titulo, LocalDate novaData) {
    Mentoria atual = listar(titulo);
    listaMentorias.get(listaMentorias.indexOf(atual)).setData(novaData);    
  }

  public void deletar(String titulo) {
    Mentoria atual = listar(titulo);
    listaMentorias.remove(atual);
  }

  public Mentoria listar(String titulo) {
    for(Mentoria c : listaMentorias) {
      if( c.getTitulo().equals(titulo) ) return c;
    }
    return null;
  }

  public List<Mentoria> listarTodos() {
    return this.listaMentorias;
  }
}