package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("ข้อมูล speaker = null จะโดย runtime exception กลับมา " +
            "พร้อมกับ message Speaker is null")
    public void case01() {
        RegisterBusiness business = new RegisterBusiness();

        // Assert exception with JUnit 5 ?
        Exception exception = assertThrows(RuntimeException.class, () -> {
            business.register(null, null);
        });
        assertEquals("Speaker is null", exception.getMessage());
    }

    @Test
    @DisplayName("First name = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า First name is required.")
    public void case02() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, new Speaker());
        });
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Last name = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า Last name is required.")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");

        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า Email is required.")
    public void case04() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");

        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email ไม่มี domain จะโยน DomainEmailInvalidException ออกมา")
    public void case05() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        speaker.setEmail("test");

        assertThrows(DomainEmailInvalidException.class, () -> {
            business.register(null, speaker);
        });

    }

    @Test
    @DisplayName("Email ี domain ไม่ใช่ gmail.com หรือ live.com จะโยน SpeakerDoesntMeetRequirementsException ออกมา"
    + "พร้อมกับคำว่า Speaker doesn't meet our standard rules.")
    public void case06() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        speaker.setEmail("test@test.com");

        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());

    }
}