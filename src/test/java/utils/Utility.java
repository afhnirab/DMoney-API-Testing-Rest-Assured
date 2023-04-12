package utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

@Getter
@Setter
public class Utility {
    public static void setEnvVariable(String key, String value) throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration("./src/test/resources/config.properties");
        configuration.setProperty(key, value);
        configuration.save();
    }
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String nid;

public void randomUserInfo() {
    Faker faker = new Faker();
    setName(faker.name().firstName());
    setEmail(faker.internet().emailAddress());
    setPassword(faker.internet().password());
    setPhone_number("0170" + randomNumber(9999999, 1000000));
    setNid("4582" + randomNumber(999999, 10000));

}

    public int randomNumber(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
}
