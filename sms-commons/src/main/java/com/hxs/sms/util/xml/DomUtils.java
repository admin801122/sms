package com.hxs.sms.util.xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class DomUtils {
	
	public static Map<String,String> toMap(String xml) {
		SAXReader reader  = new SAXReader();
		Document xmlDoc;
		try {
			xmlDoc = reader.read(new StringReader(xml));
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		return toMap(xmlDoc.getRootElement());
	}

	public static Map<String,String> toMap(Element element){
		int count = element.nodeCount();
		Map<String,String> map  = new HashMap<String, String>();
		for (int i = 0; i < count; i++) {
			Node node = element.node(i);
			if(!(node instanceof Element)){
				continue;
			}
			Element child = (Element) node;
			String name = node.getName();
			map.put(name, child.getTextTrim());
		}
		return map;
	}

	public static String toXml(Map<String, String> map , boolean sortKeys) {
		List<String> keys = new ArrayList<String>(map.keySet());
		if(sortKeys){
			Collections.sort(keys);
		}
        StringBuffer str = new StringBuffer("<xml>");
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = map.get(key);
            str.append("<").append(key).append(">");
            str.append("<![CDATA[").append(value).append("]]>");
            str.append("</").append(key).append(">\n");
        }
        str.append("</xml>");
		return str.toString();
	}
}
