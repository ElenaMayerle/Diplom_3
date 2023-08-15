import com.github.javafaker.Faker;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import lombok.Setter;
import java.util.Locale;
import static io.restassured.RestAssured.given;

@Getter
@Setter
public class User {
    private String email;
    private String name;
    private String password;
    private String token;
    Faker faker = new Faker(Locale.forLanguageTag("ru"));

    public User(){
        this.email=faker.elderScrolls().creature().replaceAll(" ", "")+"_"+faker.animal().name().replaceAll(" ", "")+"@yandex.ru";
        this.name=faker.name().firstName();
        this.password="qwerty";
    }
    public void createUser(){
        String json = "{\"email\": \"" + email + "\", \"name\": \"" + name + "\", \"password\": \"" + password + "\"}";
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(json)
                .post(Const.BURGERS_URL+Const.CREATE_USER_ENDPOINT)
                .then();
        token = response.extract().body().path("accessToken");
    }

    public void deleteUser(){
        given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .header("Authorization", token)
                .delete(Const.BURGERS_URL+Const.DELETE_USER_ENDPOINT)
                .then();
    }
}
