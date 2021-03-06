package daa.manhana.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import daa.manhana.ConfigTest;
import daa.manhana.entities.CD;

public class CDDAOTest extends ConfigTest {	
	private CDDAO CDDAO;

	@Before
	public void createEntityManager() {
		System.setProperty("persistenceUnit", "DAA-test");
		
		CDDAO = new CDDAO();
	}
	
	@Test
	public void testingFindByName() {
		List<CD> test = CDDAO.findByName("Frozen");

		assertNotNull("Find by name is not null", test);
		
		assertEquals("Length is not 1", 1, test.size());
		
		assertEquals("Id is different than 66", 66, test.get(0).getId() );
	}
	
	@Test
	public void testingFindByNameWithPagination() {
		List<CD> test = CDDAO.findByName("Broken", 1, 1);
		
		assertNotNull("Find by name with pagination is not null", test);
		
		assertEquals("Length is not 1", 1, test.size());
		
		assertEquals("Id is different than 69", 69, test.get(0).getId() );
	}
	
	@Test
	public void testingFindAllWithPagination() {
		List<CD> test = CDDAO.getAll(2, 2);
		
		assertNotNull("Find All with pagination is not null", test);
		
		assertEquals("Length is not 2", 2, test.size());
		
		assertEquals("Id is different than 63", 63, test.get(0).getId() );
	}
	
	@Test
	public void testingFindByNameNotRetrieveData() {
		List<CD> test = CDDAO.findByName("hjjasjdiefs");
		assertNotNull("Find by id is not null", test);
		
		assertEquals("Length is not 0", 0, test.size());
	}
	
	@Test
	public void testingFindById() {
		final int id = 67;
		final String name = "XSCApE";
		
		CD test = CDDAO.findById(id);
		
		assertNotNull("Find by id is null", test);
		
		assertEquals("CD ID are not equals", id, test.getId());
		
		assertEquals("CD name are not equals", name.toUpperCase(), test.getName().toUpperCase());
	}
	
	
	
	@Test
	public void testingFindAll() {
		List<CD> test = CDDAO.getAll();
		assertNotNull("Find by id is not null", test);
		
		assertEquals("Length is not 13", 13, test.size());
	}

}
