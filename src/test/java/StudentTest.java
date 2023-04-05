import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.StudentXMLRepository;
import service.Service;

@ExtendWith(MockitoExtension.class)
public class StudentTest {
    @Mock
    private StudentXMLRepository studentXmlRepo;

    @InjectMocks
    private Service service;

    @Test
    public void shouldAddStudentBeSuccessful() {
        Student student = new Student("1", "Abc", 935);
        when(studentXmlRepo.save(any())).thenReturn(student);
        assertEquals(service.saveStudent("1", "Abc", 935), 0);
    }

    @Test
    public void shouldAddStudentBeFailing() {
        when(studentXmlRepo.save(any())).thenReturn(null);
        assertEquals(service.saveStudent("2", "Abc", 935), 1);
    }

    @Test
    public void shouldAddStudentWithNaturalNumberInInterval() {
        Student student = new Student("3", "Abc", 110);
        when(studentXmlRepo.save(any())).thenReturn(student);
        assertEquals(service.saveStudent("3", "Abc", 110), 0);
        student = new Student("4", "Abc", 938);
        assertEquals(service.saveStudent("4", "Abc", 938), 0);
    }

    @Test
    public void shouldNotAddStudentWithNaturalNumberOutsideOfInterval() {
        Student student = new Student("1", "Abc", 9);
        when(studentXmlRepo.save(any())).thenReturn(null);
        assertEquals(service.saveStudent("1", "Abc", 9), 1);
    }

    @Test
    public void shouldAddStudentWithCorrectId() {
        Student student = new Student("1", "Abc", 935);
        when(studentXmlRepo.save(any())).thenReturn(student);
        assertEquals(service.saveStudent("1", "Abc", 935), 0);
    }

    @Test
    public void shouldNotAddStudentWithCorrectId() {
        assertEquals(service.saveStudent("", "Abc", 111), 1);
        assertEquals(service.saveStudent(null, "Abc", 937), 1);
    }

    @Test
    public void shouldAddStudentWithCorrectName() {
        Student student = new Student("1", "Abc", 935);
        when(studentXmlRepo.save(any())).thenReturn(student);
        assertEquals(service.saveStudent("1", "Abc", 935), 0);
    }

    @Test
    public void shouldNotAddStudentWithCorrectName() {
        assertEquals(service.saveStudent("11", "", 111), 1);
        assertEquals(service.saveStudent("12", null, 937), 1);
    }
}
