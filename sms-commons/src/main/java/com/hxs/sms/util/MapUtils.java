package com.hxs.sms.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtils {
	
	public static List<String> getKeys(Map<String,?> map , boolean isSort){
		List<String> keys = new ArrayList<String>(map.keySet());
		if(isSort){
			Collections.sort(keys);
        }
		return keys;
	}

	public static String createQueryString(Map<String,?> map, boolean isSort , boolean isUrlEncode){
		List<String> keys = getKeys(map, isSort);
		StringBuffer buff = new StringBuffer();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = map.get(key);
            String valStr;
            valStr =  value == null ? "" : value.toString();
            if(isUrlEncode){//是否编码
            	valStr = URLEncoder.encode(valStr);
            }
        	buff.append(key).append("=").append(valStr);
            if (i != keys.size() - 1) {
               buff.append("&");
            }
        }
        return buff.toString();
	}

	public static Map<String, String> filterEmpty(Map<String, String> map) {
		Map<String,String> newMap = new HashMap<String, String>(); 
		for (Entry<String, String> entry : map.entrySet()) {
			String value = entry.getValue();
			if(!StrUtils.isEmpty(value)){
				String key = entry.getKey();
				newMap.put(key, value);
			}
		}
		return newMap;
	}
}
