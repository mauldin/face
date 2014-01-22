
import com.sam.UserService;
import com.sam.model.Loginuser;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;
import java.util.List;
import javax.ejb.EJB;
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

  @EJB
  private UserService userService;
  
  @Test
  public void test() throws Exception{
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    Query q = em.createQuery("select t from Loginuser t");
    List<Loginuser> todoList = q.getResultList();
    for (Loginuser todo : todoList) {
      System.out.println(todo.getName());
    }
    Loginuser user = (Loginuser) em.createNamedQuery("Loginuser.findUserOnInfo")
                    .setParameter("name", "test")
                    .setParameter("password", "pass")
                    .getSingleResult();
    System.out.println(user.getPassword());
    System.out.println("sam !\n" + org.apache.commons.codec.digest.DigestUtils.sha256Hex("password") +"/ndigestUtilz");
    final MessageDigest messageDigest = java.security.MessageDigest.
        getInstance("SHA-256");
final byte bin[] = messageDigest.digest(("password").getBytes());
System.out.println(Base64.encode(bin));
    System.out.println("Size: " + todoList.size());


    em.close();
  }
}
