package bootcamp.dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
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
  
  protected void criar(T elemento) throws IOException, IllegalAccessException, IllegalArgumentException, 
                                          InvocationTargetException, JSONException{
    File file = criarArquivo(elemento.getClass().getSimpleName());
    JSONObject obj = parseParaJSONObject(elemento);    
    
    escrever(file, obj);
  }

  protected void deletar(T elemento) throws IllegalAccessException, IllegalArgumentException, 
                                            InvocationTargetException, JSONException, IOException {
    
    File file = criarArquivo(elemento.getClass().getSimpleName());
    JSONObject obj = parseParaJSONObject(elemento);

    List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));

    for (int i = 0; i < fileContent.size()-1; i++) {
      if (fileContent.get(i).contains(obj.toString())) {
          fileContent.set(i, "");
          break;          
      }      
    }
    Files.write(file.toPath(), fileContent, StandardCharsets.UTF_8);
        
  }

}
