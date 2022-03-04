package bootcamp;
import org.json.JSONObject;

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

        BootcampRepository rep = new BootcampRepository();
        rep.criar(new Bootcamp("nome", "descricao"));

        JSONObject a = new JSONObject();
        // a.put("key", "value");
        // System.out.println(a.toString());
        /*
        DevService service  = new DevService();

        Dev aline = new Dev("aline", "aline@email");
        Bootcamp gft = new Bootcamp("gft", "boot java");
        Especialista cami = new Especialista("camila", "cami@email", "instrutora", EspecialidadeEnum.BACKEND);
        Especialista denilson = new Especialista("denilson", "d@email", "instrutor", EspecialidadeEnum.BACKEND);
        gft.getConteudos().add(new Curso("java", "oo", cami, 60));
        gft.getConteudos().add(new Curso("spring", "api", denilson, 40));

        service.inscreverEmBootcamp(aline, gft);
        service.progredir(aline, gft);
        service.progredir(aline, gft);

        System.out.println(gft);
        System.out.println(gft.listarConteudos());
        System.out.println(gft.listarDevsInscritos());

        System.out.println(aline.getBootcampsConcluidos());
        */
    }
}
