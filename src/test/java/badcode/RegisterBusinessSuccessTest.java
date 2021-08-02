package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Firstname ของ speaker มีค่าเป็น null จึงเกิด exception ขึ้นมา")
    public void case01() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker())
        );
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Last name is null, thus the exception")
    public void case02() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Hello");
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("email is null, thus the exception")
    public void case03() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Hello");
        speaker.setLastName("There");
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Email name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("email has 2 @ , will be handled by the exception")
    public void case04() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Hello");
        speaker.setLastName("There");
        speaker.setEmail("Hello@Email@Email");
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Can not save speaker in repo, throw error")
    public void case05() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Hello");
        speaker.setLastName("There");
        speaker.setEmail("Hello@Email");
        speaker.setExp(1);
        Exception exception = assertThrows(SaveSpeakerException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Can't save a speaker.", exception.getMessage());
    }
}