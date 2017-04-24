package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Job;


@Transactional
public class JobDAOImpl implements JobDAO {
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Job> index() {
		String query = "Select j from Job j";
		  return em.createQuery(query, Job.class).getResultList();
	}

	@Override
	public Job show(int id) {
		return em.find(Job.class, id);
	}

	@Override
	public Job create(Job job) {
		System.out.println(job);
		
		Job j = em.find(Job.class, 1);
		
		em.persist(job);
		em.flush();
		return job;
	}

	@Override
	public Job update(int id, Job job) {
		System.out.println(job);
		Job j = em.find(Job.class, id);
        j.setCity(job.getCity());
        j.setTitle(job.getTitle());
        j.setCompany(job.getCompany());
        
        return job;
	}

	@Override
	public boolean destroy(int id) {
		Job j = em.find(Job.class, id);

        if (j != null) {
            em.remove(j);
            return true;
        }
        return false;
	}

}
