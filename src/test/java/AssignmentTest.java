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
    public void shouldNotAddAssignmentSuccessfullyBecauseOfIdNull() {
        Tema tema = new Tema(null, "a", 5, 1);
        assertNull(temaXMLRepository.save(tema));
    }


    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfIdEmpty() {
        Tema tema = new Tema("", "Abc", 4, 2);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfDescriereNull() {
        Tema tema = new Tema("2", null, 4, 2);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfDescriereEmpty() {
        Tema tema = new Tema("2", "", 4, 2);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfDeadlineTooSmall() {
        Tema tema = new Tema("2", "abc", -1, 2);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfDeadlineTooBig() {
        Tema tema = new Tema("2", "abc", 100, 2);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfStartlineTooSmall() {
        Tema tema = new Tema("2", "abc", 4, -1);
        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void shouldNotAddAssignmentSuccessfullyBecauseOfStartlineTooBig() {
        Tema tema = new Tema("2", "abc", 4, 100);
        assertNull(temaXMLRepository.save(tema));
    }
}
