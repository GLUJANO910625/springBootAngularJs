package com.example.demo3.Dao.daoImpl;

import com.example.demo3.Dao.EscolaridadDao;
import com.example.demo3.model.Escolaridad;
import org.springframework.stereotype.Repository;

/*
@Repository("escolaridadDao")
public class EscolaridadDaoImpl extends genericDaoImp implements EscolaridadDao {
}
*/

@Repository(value = "escolaridadDao")
public class EscolaridadDaoImpl extends genericDaoImp implements EscolaridadDao {
    public EscolaridadDaoImpl() {
        super(Escolaridad.class);
    }
    /*@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }*/
}
