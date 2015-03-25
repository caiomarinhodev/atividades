package controllers;

import models.Atividade;
import models.GenericDAO;
import play.db.jpa.Transactional;

import java.util.List;

/**
 * Created by caio on 25/03/15.
 */
public class Sistema {

    private static GenericDAO dao = new GenericDAO();

    @Transactional
    public static boolean addAtividade(Atividade a){
        if(!existeAtividade(a)){
            dao.persist(a);
            dao.flush();
            return true;
        }
        return false;
    }

    @Transactional
    public static boolean removeAtividade(Long id){
        Atividade a = getAtividade(id);
        if(a!=null){
            dao.remove(a);
            dao.flush();
            return true;
        }
        return false;
    }

    @Transactional
    public static Atividade getAtividade(Long id){
        List<Atividade> l = dao.findByAttributeName(Atividade.class.getName(),"idAtividade",String.valueOf(id));
        if (l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    @Transactional
    public static List<Atividade> getListaDeAtividades(){
        return dao.findAllByClassName(Atividade.class.getName());
    }

    @Transactional
    private static boolean existeAtividade(Atividade at){
        if(at!=null){
            List<Atividade> l = getListaDeAtividades();
            for(Atividade a: l){
                if(a.getTitulo().equals(at.getTitulo()) && a.getDescricao().equals(at.getDescricao())){
                    return true;
                }
            }
        }
        return false;
    }
}
