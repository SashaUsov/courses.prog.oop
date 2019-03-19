package homework.lessonTenth.taskOne;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EnUaMap implements Serializable{
    private Map<String, String> enUa = new HashMap<>();

    public EnUaMap() {
        enUa.put("continent", "континент");
        enUa.put("mexico", "Мехiко");
        enUa.put("hi", "привiт");
        enUa.put("goodbye", "допобачення");
        enUa.put("capital", "столиця");
        enUa.put("population", "населення");
        enUa.put("language", "мова");
        enUa.put("currency", "валюта");
        enUa.put("time", "час");
        enUa.put("football", "футбол");
        enUa.put("beautiful", "красивый");
        enUa.put("city", "мiсто");
        enUa.put("local ", "мiсцева");
        enUa.put("theatre", "театр");
    }

    public Map<String, String> getEnUa() {
        return enUa;
    }

    public void addToMap(String key, String value) {
        enUa.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnUaMap enUaMap = (EnUaMap) o;

        return enUa != null ? enUa.equals(enUaMap.enUa) : enUaMap.enUa == null;
    }

    @Override
    public int hashCode() {
        return enUa != null ? enUa.hashCode() : 0;
    }
}
