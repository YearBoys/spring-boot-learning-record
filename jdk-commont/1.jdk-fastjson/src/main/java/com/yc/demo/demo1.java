package com.yc.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.yc.domain.User;
import java.util.*;

/**
 * fastjson 基本使用
 *
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 14:44 2023/5/9
 */
public class demo1 {


    static String jsonString = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Jane\", \"age\":25}]";
    static String s = "{\"row1\":{\"userNmae\":\"zhangsan\"},\"row2\":{\"userNmae\":\"lisi\"},\"row3\":{\"userNmae\":\"wangwu\"}}";


    /**
     * String 转  JSONObject
     */
    static void stringToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);
        //  {"row1":{"userNmae":"zhangsan"},"row3":{"userNmae":"wangwu"},"row2":{"userNmae":"lisi"}}

        System.out.println("--------------");
    }


    /**
     * JSONObject 转   String
     */
    static void jsonObjectToString() {

        // string   to  json
        JSONObject jsonObject = JSONObject.parseObject(s);
        //json to string
        String jsonString = JSON.toJSONString(jsonObject);
        System.out.println(jsonString);
        //  {"row1":{"userNmae":"zhangsan"},"row3":{"userNmae":"wangwu"},"row2":{"userNmae":"lisi"}}

        System.out.println("--------------");
    }


    /**
     * TODO  转  JSONObject 保持顺序不变   start
     *     添加    Feature.OrderedField
     */
    static void toJsonObj() {

        JSONObject json1 = JSONObject.parseObject(s);
        Iterator<String> iterator = json1.keySet().iterator();
        int i = 1;
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(i + " : " + json1.get(key));
            i++;
        }

        System.out.println("--------------");
//        打印：                               实际要：
//        1 : {"userNmae":"zhangsan"}             1 : {"userNmae":"zhangsan"}
//        2 : {"userNmae":"wangwu"}               2 : {"userNmae":"lisi"}
//        3 : {"userNmae":"lisi"}                 3 : {"userNmae":"wangwu"}

        JSONObject json2 = JSONObject.parseObject(s, Feature.OrderedField);
        Iterator<String> iterator1 = json2.keySet().iterator();
        int j = 1;
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println(j + " : " + json2.get(key));
            j++;
        }
//        打印：                               实际要：
//        1 : {"userNmae":"zhangsan"}             1 : {"userNmae":"zhangsan"}
//        2 : {"userNmae":"wangwu"}               2 : {"userNmae":"wangwu"}
//        3 : {"userNmae":"lisi"}                 3 : {"userNmae":"lisi"}

        System.out.println("--------------");
    }


    /**
     * String 转 JSONArray
     */
    static void stringToJsonArray() {

        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        System.out.println(jsonArray);
        //  [{"name":"John","age":30},{"name":"Jane","age":25}]

        System.out.println("--------------");
    }


    /**
     * map 转json
     */
    static void mapToJson() {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("key1", "One");
        map.put("key2", "Two");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
        //   {"key1":"One","key2":"Two"}

        System.out.println("--------------");
    }


    /**
     * 将 List<Map> 转成JSON
     */

    static void listMapTojson() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("key1", "One");
        map1.put("key2", "Two");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");
        list.add(map1);
        list.add(map2);
        String listJson = JSON.toJSONString(list);
        System.out.println("listJson = " + listJson);
        // listJson = [{"key1":"One","key2":"Two"},{"key1":"Three","key2":"Four"}]
    }


    /**
     * 将 Java 对象转换为 JSON 字符串  or
     * 将JSON 字符串 转换为 Java 对象
     */
    static void javaBeanOrJson() {

        User user = new User(18L, "John", 14L, "john@example.com");
        String jsonStr = JSON.toJSONString(user);
        System.out.println("jsonStr = " + jsonStr);
        // jsonStr = {"age":14,"eMail":"john@example.com","id":18,"name":"John"}

        System.out.println("--------------");


        User user4 = JSON.parseObject(jsonStr, User.class);
        System.out.println("user4 = " + user4);
        // user4 = User(id=18, name=John, age=14, eMail=john@example.com)

        System.out.println("--------------");
    }


    /**
     * 将 List<T> 转换为 JSON 字符串  or
     * <p>
     * 将 JSON 字符串  转换为 List<T>
     */

    static void listJavaBeanOrJson() {

        List<User> userList = new ArrayList<>();
        User user1 = new User(18L, "John", 14L, "john@example.com");
        User user2 = new User(18L, "John", 14L, "john@example.com");
        User user3 = new User(18L, "John", 14L, "john@example.com");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        String s1 = JSON.toJSONString(userList);
        System.out.println(s1);
        //[{"age":14,"eMail":"john@example.com","id":18,"name":"John"},{"age":14,"eMail":"john@example.com","id":18,"name":"John"},{"age":14,"eMail":"john@example.com","id":18,"name":"John"}]


        System.out.println("--------------");


        List<User> userList1 = JSON.parseObject(s1, new TypeReference<List<User>>() {
        });
        System.out.println("userList1 = " + userList1);
        //userList1 = [User(id=18, name=John, age=14, eMail=john@example.com), User(id=18, name=John, age=14, eMail=john@example.com), User(id=18, name=John, age=14, eMail=john@example.com)]

        System.out.println("--------------");
    }

    public static void main(String[] args) throws Exception {
        stringToJSONObject();
        jsonObjectToString();
        toJsonObj();
        stringToJsonArray();
        mapToJson();
        listMapTojson();
        javaBeanOrJson();
        listJavaBeanOrJson();

    }






}
