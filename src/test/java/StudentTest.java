import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;

@ExtendWith(MockitoExtension.class)
public class StudentTest {

  @Mock
  private StudentXMLRepository studentXmlRepo;
  @Mock
  private TemaXMLRepository temaXmlRepo;
  @Mock
  private NotaXMLRepository notaXmlRepo;

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
    Student student = new Student("1", "Abc", 935);
    when(studentXmlRepo.save(any())).thenReturn(null);
    assertEquals(service.saveStudent("1", "Abc", 935), 1);
  }
}
