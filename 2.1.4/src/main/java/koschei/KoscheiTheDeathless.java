package koschei;
// Импорт классов из пакетов koschei.models и org.springframework.stereotype
import koschei.models.Ocean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Компонент KoscheiTheDeathless, представляющий бессмертного Кощея
@Component
public class KoscheiTheDeathless {

    // Приватное поле ocean, представляющее океан
    private Ocean1 ocean;

    // Метод для получения правил смерти
    public String getRulesByDeth() {
        return "На свете есть океан, " + ocean.toString();
    }

    // Метод для внедрения зависимости ocean
    @Autowired
    public void setOcean(Ocean1 ocean) {
        this.ocean = ocean;
    }
}
