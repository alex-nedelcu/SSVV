import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IncrementalTest {
    @Mock
    private Service service;

    @Test
    public void shouldAddStudent() {
        assertEquals(service.saveStudent("1", "test", 5), 0);
    }

    @Test
    public void shouldAddAssignment() {
        assertEquals(service.saveStudent("1", "test", 5), 0);
        assertEquals(service.saveTema("1", "test", 1, 5), 0);
    }

    @Test
    public void shouldAddGrade() {
        assertEquals(service.saveStudent("1", "test", 5), 0);
        assertEquals(service.saveTema("1", "test", 1, 5), 0);
        assertEquals(service.saveNota("1", "1", 5.5, 1, "incredibil"), 0);
    }
}