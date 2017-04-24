package data;

import java.util.List;

import entities.Job;

public interface JobDAO {


	public List<Job>index();
	public Job show(int id);
	public Job create(Job job);
	public Job update(int id, Job job);
	public boolean destroy(int id);
	
}
