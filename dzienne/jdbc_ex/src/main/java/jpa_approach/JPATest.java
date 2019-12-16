package jpa_approach;

import jpa_approach.model.Pracownik;
import jpa_approach.model.Stanowisko;

import javax.persistence.*;
import java.util.List;

public class JPATest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "PracownicyUnit"
        );
        EntityManager em = emf.createEntityManager();
        Pracownik p = em.find(Pracownik.class, 2);
        System.out.println(p.getImie() +" "+p.getNazwisko());
        System.out.println(p.getJednostki().get(0).getNazwa());
        Query q =  em.createQuery(
                " From Pracownik  as p where p.imie='Juliusz'");
        List<Pracownik> prac = q.getResultList();
        for(Pracownik p2 : prac ){
            System.out.println(p2.getId() + " "+p2.getImie() +" "+p2.getNazwisko());
        }
        Query nq = em.createNamedQuery("getStanowiskoByNazwa");
        nq.setParameter("nazwa","kierownik");
        List<Stanowisko> st = nq.getResultList();
        for (Stanowisko s : st){
            System.out.println(s.getId() +" "+s.getNazwa());
        }
    }
}
