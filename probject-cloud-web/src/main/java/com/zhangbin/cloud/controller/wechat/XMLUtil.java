package com.zhangbin.cloud.controller.wechat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	
	//通用的。返回map格式
	 /**
	     * XML格式字符串转换为Map
	     *
	     * @param strXML XML字符串
	     * @return XML数据转换后的Map
	     * @throws Exception
	     */
	    public static Map<String, String> xmlToMap(String strXML) throws Exception {
	        try {
	            Map<String, String> data = new HashMap<String, String>();
	            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
	            org.w3c.dom.Document doc = documentBuilder.parse(stream);
	            doc.getDocumentElement().normalize();
	            NodeList nodeList = doc.getDocumentElement().getChildNodes();
	            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
	                Node node = nodeList.item(idx);
	                if (node.getNodeType() == Node.ELEMENT_NODE) {
	                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
	                    data.put(element.getNodeName(), element.getTextContent());
	                }
	            }
	            try {
	                stream.close();
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	            }
	            return data;
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	            throw ex;
	        }

	    }
}
