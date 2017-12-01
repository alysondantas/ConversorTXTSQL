/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversortxtsql;

/**
 *
 * @author marcos
 */
public class DAO {
    public static void gerarInsert(Questao q){
        String qu = "INSERT INTO public.questao (idusuario,"
                + "idprova,"
                + "idareaconhecimento,"
                + "enunciado,"
                + "questaooficial,"
                + "respostaa,"
                + "respostab,"
                + "respostac,"
                + "respostad,"
                + "respostae,"
                + "respostacorreta) VALUES('','','"+q.getEnunciado()+"',"
                + "'OFICIAL','"+q.getRespostaA()+"','','','','','');";
    }
}
