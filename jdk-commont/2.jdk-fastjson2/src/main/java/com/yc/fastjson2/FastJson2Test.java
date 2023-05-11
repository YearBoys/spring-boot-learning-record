package com.yc.fastjson2;
 
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

/**
 * TODO  用法基本和fastjson 一致
 *
 *   <a href="https://gitcode.net/mirrors/alibaba/fastjson2?utm_source=csdn_github_accelerator">文档</a>
 */
public class FastJson2Test {


    public static void main(String[] args) {

        JSONObject info = new JSONObject();
        info.put("name", "张三");
        info.put("age", "18");
        info.put("地理", "70");
        info.put("英语", "60");

        //JSON对象转字符串
        String str = JSON.toJSONString(info);
        //JSON字符串转JSON对象
        JSONObject json = JSON.parseObject(str);
        System.out.println(json);

        //获取简单属性
        String text = "{\"id\": 2,\"name\": \"fastjson2\"}";
        JSONObject obj = JSON.parseObject(text);

        int id = obj.getIntValue("id");
        String name = obj.getString("name");
        String text1 = "[2, \"fastjson2\"]";
        JSONArray array = JSON.parseArray(text1);

        int id1 = array.getIntValue(0);
        String name1 = array.getString(1);


    }



 
//    public static void main(String[] args){
//
//        String str = "{\"id\":100}";
//        JSONObject jsonObject = JSON.parseObject(str);
//        int id = jsonObject.getIntValue("id");
//        String str1 = "[\"id\", 100]";
//        JSONArray jsonArray = JSON.parseArray(str);
//        String name = jsonArray.getString(0);
//        int id1 = jsonArray.getIntValue(1);
//
//        System.out.println("id--"+id+"--id1--"+id1+"--str--"+str+"--str1--"+str1);
//    }
}