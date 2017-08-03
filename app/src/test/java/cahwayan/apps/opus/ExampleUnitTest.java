package cahwayan.apps.opus;

import android.util.Log;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Map<String, String> map = new HashMap<>();

        map.put("HEY", "Teste");


        assertNotNull(map.get("HEY"));
        assertEquals("Teste", map.get("HEY"));

    }
}