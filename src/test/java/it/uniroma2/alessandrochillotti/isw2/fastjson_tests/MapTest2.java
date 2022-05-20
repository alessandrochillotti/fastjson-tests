package it.uniroma2.alessandrochillotti.isw2.fastjson_tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@RunWith(Parameterized.class)
public class MapTest2 {
	private String text;
	private Map<Object, Object> expected_map;
	
	private Map<Object, Object> map;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{ "{1:\"2\",\"3\":4,'5':6}", build_expected_map(Map.entry(1, "2"), Map.entry("3", 4), Map.entry("5", 6)) } // text, expected map
        });
    }
	
	public void configure(String text, Map<Object, Object> expected_map) {
		this.text = text;
		this.expected_map = expected_map;			
		map = JSON.parseObject(this.text, new TypeReference<Map<Object, Object>>() {});
	}
	
	private static Map<Object, Object> build_expected_map(Entry<Object,Object>... elements) {
		Map<Object,Object> expected_map = new HashMap<>();
		
		for (Entry<Object,Object> entry : elements)
			expected_map.put(entry.getKey(), entry.getValue());
		
		return expected_map;
	}
	
	public MapTest2(String text, Map<Object, Object> expected_map) {
		configure(text, expected_map);
	}
	
	@Test
	public void test_map() throws Exception {
		for (Entry<Object, Object> entry : expected_map.entrySet())
			Assert.assertEquals(entry.getValue(), map.get(entry.getKey()));
	}
}
