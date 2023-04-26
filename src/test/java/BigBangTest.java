import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import domain.Tema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.Service;

@ExtendWith(MockitoExtension.class)
public class BigBangTest {
    @Mock
    private Service service;

    @Test
    public void shouldAddStudentSuccessfully() {
        assertEquals(service.saveStudent("1", "test", 5), 0);
    }

    @Test
    public void shouldAddAssignmentSuccessfully() {
        assertEquals(service.saveTema("1", "test", 1, 5), 0);
    }

    @Test
    public void shouldAddGradeSuccessfully() {
        assertEquals(service.saveNota("1", "1", 5.5, 1, "incredibil"), 0);
    }

    @Test
    public void shouldAddAll() {
        assertEquals(service.saveStudent("1", "test", 5), 0);
        assertEquals(service.saveTema("1", "test", 1, 5), 0);
        assertEquals(service.saveNota("1", "1", 5.5, 1, "incredibil"), 0);
    }
}
