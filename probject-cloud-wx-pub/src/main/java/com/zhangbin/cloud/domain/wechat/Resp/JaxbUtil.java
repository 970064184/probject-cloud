package com.zhangbin.cloud.domain.wechat.Resp;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class JaxbUtil
{
    protected static String PREFIX_CDATA    = "<![CDATA[";
    protected static String SUFFIX_CDATA    = "]]>";

    /*public static void main(String[] args) {
        XStream xstream = initXStream(true);
        xstream.alias("order", Img.class);
        Img img = new Img();
        img.setUrl("<![CDATA[dfsdfsdfsdf]]>");
        String xml = xstream.toXML(img);
        System.out.println(xml);
    }*/

    /**
     * 初始化XStream
     * 可支持某一字段可以加入CDATA标签
     * 如果需要某一字段使用原文
     * 就需要在String类型的text的头加上"<![CDATA["和结尾处加上"]]>"标签，
     * 以供XStream输出时进行识别
     * @param isAddCDATA 是否支持CDATA标签
     * @return
     */
    public static XStream initXStream(boolean isAddCDATA) {
        XStream xstream = null;
        if (isAddCDATA) {
            xstream = new XStream(
                    new XppDriver() {
                        public HierarchicalStreamWriter createWriter(Writer out) {
                            return new PrettyPrintWriter(out) {
                                protected void writeText(QuickWriter writer, String text) {
                                    if (text.startsWith(PREFIX_CDATA)
                                            && text.endsWith(SUFFIX_CDATA)) {
                                        writer.write(text);
                                    } else {
                                        super.writeText(writer, text);
                                    }
                                }
                            };
                        }

                        ;
                    }
            );
        } else {
            xstream = new XStream();
        }
        return xstream;
    }


        /**
         * 日志
         */

    public static String convertToXml (Object obj)
    {
        return convertToXml (obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     *
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml (Object obj, String encoding)
    {
        String result = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance (obj.getClass ());
            Marshaller marshaller = context.createMarshaller ();
            marshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty (Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter ();
            marshaller.marshal (obj, writer);
            result = writer.toString ();
        }
        catch (Exception ex)
        {
        }
        return result;
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings ("unchecked")
    public static <T> T converyToJavaBean (String xml, Class <T> c)
    {
        T t = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance (c);
            Unmarshaller unmarshaller = context.createUnmarshaller ();
            t = (T) unmarshaller.unmarshal (new StringReader(xml));
        }
        catch (Exception ex)
        {
        }
        return t;
    }

}