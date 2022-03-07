package bootcamp;
import org.json.JSONObject;

import bootcamp.controller.BootcampController;
import bootcamp.controller.CursoController;
import bootcamp.dados.BootcampRepository;
import bootcamp.dominio.Bootcamp;
import bootcamp.dominio.conteudo.Conteudo;
import bootcamp.dominio.conteudo.Curso;
import bootcamp.dominio.pessoa.Dev;
import bootcamp.dominio.pessoa.Especialista;
import bootcamp.service.DevService;
import bootcamp.util.EspecialidadeEnum;

// import org.json.JSONObject;
// import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BootcampController c = new BootcampController();
        c.criar("GFT 190", "Java");
        c.deletar("GFT 190");
        // CursoController cr = new CursoController();
        // cr.criar("GFT 4", "Java", new Especialista("nome", "email", "cargo", EspecialidadeEnum.BACKEND), 99);
        // BootcampController c = new BootcampController();
        // c.criar("GFT 4", "Java");
    }
}
