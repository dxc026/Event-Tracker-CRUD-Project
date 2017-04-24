import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Job;



public class JETtest {
	private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private Job job;

@Before
      public void setUp() throws Exception {
         emf = Persistence.createEntityManagerFactory("JobEventTracker");
         em = emf.createEntityManager();
         job = em.find(Job.class, 1);
         
     }
     @After
      public void tearDown() throws Exception {
         em.close();
         emf.close();    
     }
    
    
    
     @Test
     public void test_job_mapping() {
        assertEquals("Frost", job.getCompany());
     }
		
}
