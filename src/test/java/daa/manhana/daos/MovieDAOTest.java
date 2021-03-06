package daa.manhana.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import daa.manhana.ConfigTest;
import daa.manhana.entities.Movie;

public class MovieDAOTest extends ConfigTest {
	private MovieDAO movieDAO;

	
	@Before
	public void createEntityManager() {
		movieDAO = new MovieDAO();
	}	
	
	@Test
	public void testingFindByName() {
		List<Movie> test = movieDAO.findByName("Cadena");
		assertNotNull("Find by name is not null", test);
		
		assertEquals("Length is not 1", 1, test.size());
		
		assertEquals("Id is different than 2", 2, test.get(0).getId() );
	}
	
	@Test
	public void testingFindByNameWithPagination() {
		List<Movie> test = movieDAO.findByName("p", 1, 2);
		
		assertNotNull("Find by name is not null", test);
		
		assertEquals("Length is not 2", 2, test.size());
		
		assertEquals("Id is different than 1", 1, test.get(0).getId() );
	}
	
	@Test
	public void testingFindAllWithPagination() {
		List<Movie> test = movieDAO.getAll(1, 2);
		
		assertNotNull("Find All with pagination is not null", test);
		
		assertEquals("Length is not 2", 2, test.size());
		
		assertEquals("Id is different than 23", 23, test.get(0).getId() );
	}
	
	@Test
	public void testingFindByNameNotRetrieveData() {
		List<Movie> test = movieDAO.findByName("hjjasjdiefs");
		assertNotNull("Find by id is not null", test);
		
		assertEquals("Length is not 0", 0, test.size());
	}
	
	@Test
	public void testingFindById() {
		final int id = 2;
		final String name = "Cadena Perpetua";
		
		Movie test = movieDAO.findById(id);
		
		assertNotNull("Find by id is null", test);
		
		assertEquals("Movie ID are not equals", id, test.getId());
		
		assertEquals("Movie name are not equals", name.toUpperCase(), test.getName().toUpperCase());
	}
	
	
	
	@Test
	public void testingFindAll() {
		List<Movie> test = movieDAO.getAll();
		assertNotNull("Find by id is not null", test);
		
		assertEquals("Length is not 33", 33, test.size());
	}

}
