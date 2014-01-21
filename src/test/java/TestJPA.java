
import com.sam.LoginUser;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class TestJPA {
    private static final String PERSISTENCE_UNIT_NAME = "test";
  private static EntityManagerFactory factory;

  @Test
  public void test() {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    Query q = em.createQuery("select t from LoginUser t");
    List<LoginUser> todoList = q.getResultList();
    for (LoginUser todo : todoList) {
      System.out.println(todo);
    }
    System.out.println("Size: " + todoList.size());


    em.close();
  }
}
