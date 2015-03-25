package models;

import play.db.jpa.JPA;

import javax.persistence.Query;

import java.util.List;

/**
 * Camada genérica para acesso ao Banco de Dados
 */
public class GenericDAO {

    public boolean persist(Object e) {
        JPA.em().persist(e);
        return true;
    }

    public void flush() {
        JPA.em().flush();
    }

    public void merge(Object e) {
        JPA.em().merge(e);
    }

    public <T> T findByEntityId(Class<T> clazz, Long id) {
        return JPA.em().find(clazz, id);
    }

    public <T> List<T> findAllByClassName(String className) {
        String hql = "FROM " + className;
        Query hqlQuery = JPA.em().createQuery(hql);
        return hqlQuery.getResultList();
    }

    public <T> void removeById(Class<T> classe, Long id) {
        JPA.em().remove(findByEntityId(classe, id));
    }

    public void remove(Object objeto) {
        JPA.em().remove(objeto);
    }

    public <T> List<T> findByAttributeName(String className,
                                           String attributeName, String attributeValue) {
        String hql = "FROM " + className + " c" + " WHERE c." + attributeName
                + " = '" + attributeValue + "'";
        Query hqlQuery = JPA.em().createQuery(hql);
        return hqlQuery.getResultList();
    }

    public Query createQuery(String query) {
        return JPA.em().createQuery(query);
    }
}