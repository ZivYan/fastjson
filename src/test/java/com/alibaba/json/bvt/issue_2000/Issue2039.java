package com.alibaba.json.bvt.issue_2000;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @Author ：Nanqi
 * @Date ：Created in 23:30 2020/7/10
 */
public class Issue2039 extends TestCase {
    public void test_for_issue() throws Exception {
        InnerModel innerModel = new InnerModel();
        innerModel.setDecimal(new BigDecimal("49e99999999"));
        Model model = new Model();
        model.setDecimal(new BigDecimal("49e999999999"));
        model.setInnerModel(innerModel);
        String decimalString = JSON.toJSONString(new BigDecimal("49e999999999"), SerializerFeature.WriteBigDecimalAsPlain);
        String modelJSON = JSON.toJSONString(model, SerializerFeature.WriteBigDecimalAsPlain);
        System.out.println(modelJSON);
    }

    static class Model {
        private BigDecimal decimal;

        private InnerModel innerModel;

        public BigDecimal getDecimal() {
            return decimal;
        }

        public void setDecimal(BigDecimal decimal) {
            this.decimal = decimal;
        }

        public InnerModel getInnerModel() {
            return innerModel;
        }

        public void setInnerModel(InnerModel innerModel) {
            this.innerModel = innerModel;
        }
    }

    static class InnerModel {
        private BigDecimal decimal;

        public BigDecimal getDecimal() {
            return decimal;
        }

        public void setDecimal(BigDecimal decimal) {
            this.decimal = decimal;
        }
    }
}
