package bootcamp.dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
// import org.json.simple.JSONObject;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONWriter;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import bootcamp.dominio.Bootcamp;

public class Arquivo<T> {
  private final String path = "src\\main\\java\\bootcamp\\dados\\arquivos\\"; 
  private final String extensao = ".json";

  private File criarArquivo(String nomeArquivo) {    
    File file = new File(path + nomeArquivo + extensao);
    
    try {
      file.createNewFile();
    } catch (IOException e) {      
      e.printStackTrace();
    }
    
    return file;
  }
  
  private void escrever(File file, JSONObject objeto) {
    FileWriter writer;
    try {
      if (file.length() == 0) {        
        writer = new FileWriter(file, true);
        writer.write("{ \"" + objeto.getClass().getSimpleName().toLowerCase() + "s\":[\n");  
        writer.write(objeto + "\n");
        writer.write("]}");  
      } else {    
        List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals("]}")) {
                fileContent.set(i, ", " + objeto);
                break;
            }
        }
        
        Files.write(file.toPath(), fileContent, StandardCharsets.UTF_8);

        writer = new FileWriter(file, true);
        writer.write("]}");              
      }
      writer.close();
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

  private JSONObject parseParaJSONObject(T elemento) throws IllegalAccessException, IllegalArgumentException, 
                                                              InvocationTargetException, JSONException {
    JSONObject obj = new JSONObject();
    Method[] methods = elemento.getClass().getMethods();   

    for(Method m : methods) {
      if(m.getName().contains("get") && 
        !m.getName().contains("Class") &&
        !m.getReturnType().getSimpleName().equals("Set") &&
        !m.getReturnType().getSimpleName().equals("List") &&
        !m.getReturnType().getSimpleName().equals("Map")) {    
          obj.put(m.getName().split("get")[1], m.invoke(elemento));        
      } 
    }
    
    return obj;
  }
  
  protected List<T> carregarDados(String nomeArquivo) {

  }
  
  protected void criar(T elemento) throws IOException, IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException{
    File file = criarArquivo(elemento.getClass().getSimpleName());
    JSONObject obj = parseParaJSONObject(elemento);    
    
    escrever(file, obj);
  }

  
  // protected void editarDescricao(String nome, String novaDescricao) {
  //   Bootcamp atual = listar(nome);
  //   listaBootcamps.get(listaBootcamps.indexOf(atual)).setDescricao(novaDescricao);    
  // }

  protected void deletar(T elemento) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    
                                              File file = criarArquivo(elemento.getClass().getSimpleName());
    JSONObject obj = parseParaJSONObject(elemento);

    List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));

    for (int i = 0; i < fileContent.size(); i++) {
      System.out.println("file contents: " + fileContent.get(i));
      System.out.println("obj: " + obj.toString());
      if (fileContent.get(i).contains(obj.toString())) {
          System.out.println("É esse: " + fileContent.get(i));
          fileContent.set(i, "");
          break;          
      }      
    }
    Files.write(file.toPath(), fileContent, StandardCharsets.UTF_8);
        
  }

  /*
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
