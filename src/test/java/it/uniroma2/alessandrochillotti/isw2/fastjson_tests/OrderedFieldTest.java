package it.uniroma2.alessandrochillotti.isw2.fastjson_tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

@RunWith(Parameterized.class)
public class OrderedFieldTest {
	private String text;
	private Feature feature;
	private int expected_id;
	
	private Model model;
	
	public static interface Model {
		public int getId();
		public void setId(int value);
	}
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "{\"id\":1001}", Feature.OrderedField, 1001 } // text, feature, expected id
        });
    }
	
	public void configure(String text, Feature feature, int expected_id) {
		this.text = text;
		this.feature = feature;
		this.expected_id = expected_id;
		model = JSON.parseObject(this.text, Model.class, this.feature);
	}
	
	public OrderedFieldTest(String text, Feature feature, int expected_id) {
		configure(text, feature, expected_id);
	}
	
	@Test
	public void test_ordered_field() throws Exception {
		Assert.assertEquals(expected_id, model.getId());
		Assert.assertEquals(text, JSON.toJSONString(model));
	}
}