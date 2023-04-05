import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import domain.Tema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.TemaXMLRepository;

@ExtendWith(MockitoExtension.class)
public class AssignmentTest {

  @Mock
  private TemaXMLRepository temaXMLRepository;

  @Test
  public void shouldAddAssignmentSuccessfully() {
    Tema tema = new Tema("1", "a", 5, 1);
    when(temaXMLRepository.save(any())).thenReturn(tema);
    assertEquals(temaXMLRepository.save(tema).getID(), "1");
  }

  @Test
  public void shouldNotAddAssignmentSuccessfully() {
    Tema tema = new Tema(null, "a", 5, 1);
    assertNull(temaXMLRepository.save(tema));
  }
}
