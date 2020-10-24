import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServicesConfig {

    @Bean(name="validatorShort")
    public UsernameValidator validatorShort() {
        return new UsernameValidator(3);
    }

    @Bean(name="validatorLong")
    @Primary
    public UsernameValidator validatorLong() {
        return new UsernameValidator(8);
    }
}

class UsernameValidator {
    private int minLength;

    public UsernameValidator(int minLength) {
        this.minLength = minLength;
    }

    public boolean isUsernameValid(String username) {
        return username.length() >= minLength;
    }
}
