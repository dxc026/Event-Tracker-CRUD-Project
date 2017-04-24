package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.JobDAO;
import entities.Job;


@RestController
public class JobController {

	@Autowired
	private JobDAO jDAO;

	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "jobs", method = RequestMethod.GET)
	public List<Job> index() {
		return jDAO.index();
	}

	@RequestMapping(value = "jobs/{id}", method = RequestMethod.GET)
	public Job show(@PathVariable int id) {
		return jDAO.show(id);
	}

	@RequestMapping(value = "jobs", method = RequestMethod.POST)
	public Job create(@RequestBody String jobJSON, HttpServletResponse res) {
		
		ObjectMapper om = new ObjectMapper();
		try {
			Job mappedJob = om.readValue(jobJSON, Job.class);
			
			return jDAO.create(mappedJob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	@RequestMapping(value = "jobs/{id}", method = RequestMethod.PUT)
	public Job update(@PathVariable int id, @RequestBody String jobJSON, HttpServletResponse res) {
		ObjectMapper mapper = new ObjectMapper();
	System.out.println("ddddddddddddddddddddddddd"+id);
		try {
		Job	newJob = mapper.readValue(jobJSON, Job.class);
		return jDAO.update(id, newJob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "jobs/{id}", method = RequestMethod.DELETE)
	public  @ResponseBody boolean destroy(@PathVariable int id) {
		return jDAO.destroy(id);
		

	}
}
