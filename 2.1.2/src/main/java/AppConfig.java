import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// Аннотация @Configuration говорит Spring, что этот класс является конфигурационным классом.
public class AppConfig {

    @Bean(name="helloworld")
    // Аннотация @Bean указывает на то, что метод должен создавать бин с именем "helloworld".
    public HelloWorld getHelloWorld() {
        // Создание нового экземпляра класса HelloWorld
        HelloWorld helloWorld = new HelloWorld();
        // Установка сообщения в экземпляре класса HelloWorld
        helloWorld.setMessage("Hello World!");
        // Возврат созданного экземпляра класса HelloWorld
        return helloWorld;
    }

    @Scope("prototype")
    // Аннотация @Scope указывает на то, что бины, созданные этим методом, будут иметь прототипный скоуп.
    @Bean(name="cat")
    // Аннотация @Bean указывает на то, что метод должен создавать бин с именем "cat".
    public Cat getCat() {
        // Создание нового экземпляра класса Cat
        Cat cat = new Cat();
        // Установка сообщения в экземпляре класса Cat
        cat.setMessage("meow");
        // Возврат созданного экземпляра класса Cat
        return cat;
    }
}
