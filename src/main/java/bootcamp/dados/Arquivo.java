package bootcamp.dados;

import java.io.File;
import java.io.IOException;
// import org.json.simple.JSONObject;

import bootcamp.dominio.Bootcamp;

public class Arquivo<T> {
  private File recuperarArquivo(String nomeArquivo, Class<? extends Object> classe) {
    // String path = this.getClass().getClass().get
    // File file = new File(".\\arquivos\\nomeArquivo.txt");
    File file = new File("src\\main\\java\\bootcamp\\dados\\arquivos\\" + nomeArquivo + ".txt");
    // JSONObject a;
    try {
      file.createNewFile();
    } catch (IOException e) {      
      e.printStackTrace();
    }
    return file;
  }
  
  protected void criar(T elemento) throws IOException{
    File file = recuperarArquivo(elemento.getClass().getSimpleName(), elemento.getClass());
    System.out.println(file.getCanonicalPath());
    // System.out.println(elemento.getClass().getSimpleName());
    
  }

  /*
  protected void editarDescricao(String nome, String novaDescricao) {
    Bootcamp atual = listar(nome);
    listaBootcamps.get(listaBootcamps.indexOf(atual)).setDescricao(novaDescricao);    
  }

  protected void deletar(String nome) {
    Bootcamp atual = listar(nome);
    listaBootcamps.remove(atual);
  }

  protected Bootcamp listar(String nome) {
    for(Bootcamp b : listaBootcamps) {
      if( b.getNome().equals(nome) ) return b;
    }
    return null;
  }

  protected List<Bootcamp> listarTodos() {
    return this.listaBootcamps;
  }

  */
}
