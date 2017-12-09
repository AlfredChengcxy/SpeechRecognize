package com.iflytek.msp.lfasr;

/**
 * Created by mac on 2017/12/9.
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class JsonHelper {


    /**
     * 将jsonString中属于key的values拼接成一个字符串
     * @param jsonString
     * [{"bg":"920","ed":"3370","onebest":"啊在用的一些场景，","speaker":"0"},...,{"bg":"3390","ed":"7560","onebest":"然后就工具，然后后面，现在我们","speaker":"0"}]
     * JsonArray<JsonObject<HashMap@Node>>
     * @param key   "onebest"
     * @param split '。'
     * @return  啊在用的一些场景，。然后就工具，然后后面，现在我们。
     *
     *
     */
    public static String concat(String jsonString,String key,char split){
        JSONArray jsonArray = (JSONArray) JSONObject.parse(jsonString);
        Object[] array = jsonArray.toArray();
        StringBuilder resultStringBuilder = new StringBuilder();
        for (Object o : array){
            JSONObject jsonObject = (JSONObject) o;
            String onebest = (String)jsonObject.get("onebest");
            if (onebest.charAt(onebest.length() - 1) == '，'){
                resultStringBuilder.append(onebest);
            }
            else{
                resultStringBuilder.append(onebest+'。');
            }
        }

        return resultStringBuilder.toString();

    }

    public static void main(String[] args){
       String jsonString ="[{\"bg\":\"920\",\"ed\":\"3370\",\"onebest\":\"啊在用的一些场景，\",\"speaker\":\"0\"},{\"bg\":\"3390\",\"ed\":\"7560\",\"onebest\":\"然后就工具，然后后面，现在我们\",\"speaker\":\"0\"}]";
       String key = "onebest";
       char split = '。';

       JSONArray jsonArray = (JSONArray) JSONObject.parse(jsonString);
       Object[] array = jsonArray.toArray();
       StringBuilder resultStringBuilder = new StringBuilder();
       for (Object o : array){
           JSONObject jsonObject = (JSONObject) o;
           String onebest = (String)jsonObject.get("onebest");
           if (onebest.charAt(onebest.length() - 1) == '，'){
                resultStringBuilder.append(onebest);
           }
           else{
                resultStringBuilder.append(onebest+'。');
           }
       }

       String result = resultStringBuilder.toString();
        System.out.println(result);                     
    }
}
