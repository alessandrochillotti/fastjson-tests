package it.uniroma2.alessandrochillotti.isw2.fastjson_tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@RunWith(Parameterized.class)
public class SndMapTest {
	private String text;
	private Map<Object, Object> expected_map;
	
	private Map<Object, Object> map;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "{1:\"2\",\"3\":4,'5':6}", build_expected_map() } // text, expected map
        });
    }
	
	@Before
	public void configure() {
		map = JSON.parseObject(this.text, new TypeReference<Map<Object, Object>>() {});
	}
	
	private static Map<Object, Object> build_expected_map() {
		Map<Object,Object> expected_map = new HashMap<>();
		
		expected_map.put(1, "2");
		expected_map.put("3", 4);
		expected_map.put("5", 6);
		
		return expected_map;
	}
	
	public SndMapTest(String text, Map<Object, Object> expected_map) {
		this.text = text;
		this.expected_map = expected_map;
	}
	
	@Test
	public void test_map() throws Exception {
		for (Entry<Object, Object> entry : expected_map.entrySet())
			Assert.assertEquals(entry.getValue(), map.get(entry.getKey()));
	}
}
