package com.alibaba.json.bvt.issue_3200;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Assert;

import java.util.Date;

/**
 * @Author ：Nanqi
 * @Date ：Created in 21:29 2020/6/22
 */
public class Issue3274 extends TestCase {
    public void test_for_issue() throws Exception {
        String str = "{\"data\":{\"id\":1,\"name\":\"n1\"}}";
        MyData2 d1 = JSON.parseObject(str, MyData2.class);

        JSONObject data = JSON.parseObject(str);
        MyData d2 = data.getObject("data", MyData.class);

        Assert.assertTrue(1 == d1.getData().getId());
        Assert.assertTrue(1 == d2.getId());
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class MyData {
        private Integer id;

        private String name;

        private Date date;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class MyData2 {
        MyData data;
    }
}
