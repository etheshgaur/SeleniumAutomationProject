package Utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {


    private Map<ContextKey, Object> data = new HashMap<>();

    public void setContext(ContextKey key, Object value) {
        data.put(key, value);
    }

    public Object getContext(ContextKey key) {
        return data.get(key);
    }

    public Boolean contains(ContextKey key) {
        return data.containsKey(key);
    }
}
