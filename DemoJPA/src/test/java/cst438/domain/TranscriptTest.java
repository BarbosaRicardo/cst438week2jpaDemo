package cst438.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TranscriptTest {
	
	@Autowired
	TranscriptRepository transcriptRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	@Test
	public void test1() {
		Course c;
		Transcript t;
		
		// delete any database data
		transcriptRepository.deleteAll();
		
		// create test transcript containing 2 courses
		t = new Transcript(1001, "Thomas Thumb");
		
		c = new Course("CST438 Software Engineering", "Spring", 2020, 4, "A-", t);
		t.getCourses().add(c);
		
		c = new Course("CST338 Software Design", "Spring", 2020, 4, "A-", t);		
		t.getCourses().add(c);
		
		transcriptRepository.save(t);
	
		// now, retrieve and verify that courses are returned in correct order
		Transcript u = transcriptRepository.findById(1001);
		assertEquals("Thomas Thumb", u.getStudentName());
		assertEquals(2, u.getCourses().size());
		assertEquals("CST438 Software Engineering", u.getCourses().get(1).getTitle());
		assertEquals("CST338 Software Design", u.getCourses().get(0).getTitle());
		
		
		// create test transcript containing 3 courses
		t = new Transcript(2001, "Bob Burger");

		c = new Course("CST438 Software Engineering", "Spring", 2020, 4, "A", t);
		t.getCourses().add(c);
		c = new Course("CST311 Networking", "Spring", 2020, 4, "A", t);		
		t.getCourses().add(c);
		c = new Course("CST300 Pro Seminar", "Fall", 2019, 4, "B+", t);		
		t.getCourses().add(c);
		
		transcriptRepository.save(t);
	
		// now, retrieve and verify that courses are returned in correct order.
		Transcript w = transcriptRepository.findById(2001);
		assertEquals("Bob Burger", w.getStudentName());
		assertEquals(3, w.getCourses().size());
		assertEquals("CST438 Software Engineering", w.getCourses().get(2).getTitle());
		assertEquals("CST311 Networking", w.getCourses().get(1).getTitle());
		assertEquals("CST300 Pro Seminar", w.getCourses().get(0).getTitle());
				
	}
}