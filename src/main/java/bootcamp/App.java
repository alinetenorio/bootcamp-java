package bootcamp;

import bootcamp.controller.BootcampController;
import bootcamp.controller.DevController;
import bootcamp.dominio.conteudo.Curso;
import bootcamp.dominio.pessoa.Especialista;
import bootcamp.util.EspecialidadeEnum;

public class App {
    public static void main(String[] args) throws Exception {

        BootcampController c = new BootcampController();
        c.criar("GFT 4", "Java");
        c.listar("GFT 4").getConteudos().add(new Curso("titulo"," descricao", new Especialista("nome",
                 "email", "cargo", EspecialidadeEnum.BACKEND), 7));

        c.criar("GFT 190", "Java");
        c.deletar("GFT 190");

        DevController d = new DevController();
        d.criar("teste", "teste@email");
        d.inscreverEmBootcamp("teste@email", "GFT 4");
        System.out.println(d.progredir("teste@email", "GFT 4"));

    }
}
