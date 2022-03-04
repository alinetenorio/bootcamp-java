package bootcamp.dados;

import java.io.File;
import java.io.IOException;
// import org.json.simple.JSONObject;
import java.lang.reflect.Method;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONWriter;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import bootcamp.dominio.Bootcamp;

public class Arquivo<T> {
  private File recuperarArquivo(String nomeArquivo) {    
    File file = new File("src\\main\\java\\bootcamp\\dados\\arquivos\\" + nomeArquivo + ".txt");
    // JSONObject a;
    try {
      file.createNewFile();
    } catch (IOException e) {      
      e.printStackTrace();
    }
    
    return file;
  }
  
  protected void criar(T elemento) throws IOException, Exception{
    File file = recuperarArquivo(elemento.getClass().getSimpleName());
    System.out.println(file.getCanonicalPath());
    JSONObject a = new JSONObject();
    Method[] m = elemento.getClass().getMethods();
    for(Method me : m) {
      if(me.getName().contains("get") && 
        !me.getName().contains("Class") &&
        !me.getReturnType().getSimpleName().equals("Set") &&
        !me.getReturnType().getSimpleName().equals("List") &&
        !me.getReturnType().getSimpleName().equals("Map")) {
       
        System.out.println(me.getName());
        a.put(me.getName().split("get")[1], me.invoke(elemento));
        System.out.println("a: " + a);
      } 
    }
    a.put("key", "value");
    System.out.println(JSONValue.toJSONString(a));
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
