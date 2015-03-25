package controllers;

import models.Atividade;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    @Transactional
    public static Result index() {
        return ok(index.render("",Sistema.getListaDeAtividades()));
    }

    @Transactional
    public static Result renderAdd(){
        return ok(add.render(""));
    }

    @Transactional
    public static Result addAtividade(){
        DynamicForm r = Form.form().bindFromRequest();
        String titulo = r.get("titulo");
        String desc = r.get("descricao");
        Atividade a = new Atividade(titulo,desc);
        if(Sistema.addAtividade(a)){
            return index();
        }
        return renderAdd();
    }

    @Transactional
    public static Result removeAtividade(Long id){
        //Long ida = Long.parseLong(id);
        if(Sistema.removeAtividade(id)){
            return index();
        }
        return index();
    }



}
