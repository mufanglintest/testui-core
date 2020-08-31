package com.jorge.testui.utils;

import com.acooly.core.common.exception.BusinessException;
import com.google.common.collect.Maps;
import com.jorge.testui.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2019/12/13 0029
 */
@Slf4j
public class RequestUtils {


    /**
     * <一句话功能简述>
     * <功能详细描述>request转字符串
     *
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String parseRequst(HttpServletRequest request) {
        String body = "";
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String info = br.readLine();
                if (info == null) {
                    break;
                }
                if (body == null || "".equals(body)) {
                    body = info;
                } else {
                    body += info;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 数据格式转化：SortedMap转XML
     * @param parameters
     * @return
     */
    public static String parseXML(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xmlbean>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
                sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
            }
        }
        sb.append("</xmlbean>");
        return sb.toString();
    }

    /**
     * 从request中获得参数Map，并返回可读的Map
     *
     * @param request
     * @return
     */
    public static SortedMap getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        SortedMap returnMap = new TreeMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value.trim());
        }
        return returnMap;
    }

    /**
     * 数据格式转化：XML转Map
     *
     * @param xmlBytes
     * @param charset
     * @return
     * @throws Exception
     * @author
     */
    public static Map<String, String> toMap(byte[] xmlBytes, String charset) throws Exception {
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
        source.setEncoding(charset);
        Document doc = reader.read(source);
        Map<String, String> params = RequestUtils.toMap(doc.getRootElement());
        return params;
    }

    /**
     * 数据格式转化：XML转Map
     * @param xmlstr
     * @return
     * @throws Exception
     */
    public static Map<String, String> toMap(String xmlstr) throws Exception {
        Document doc = DocumentHelper.parseText(xmlstr);
        //获取根目录
        Element rootEle = doc.getRootElement();

        Map<String, String> params = RequestUtils.toMap(doc.getRootElement());
        return params;
    }

    /**
     * 转MAP
     *
     * @param element
     * @return
     * @author
     */
    public static Map<String, String> toMap(Element element) {
        Map<String, String> rest = new HashMap<String, String>();
        List<Element> els = element.elements();
        for (Element el : els) {
            rest.put(el.getName().toLowerCase(), el.getTextTrim());
        }
        return rest;
    }

    /**
     * 数据格式转化：Map转XML
     * @param params
     * @return
     */
    public static String toXml(Map<String, String> params) {
        StringBuilder buf = new StringBuilder();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        buf.append("<xmlbean>");
        for (String key : keys) {
            buf.append("<").append(key).append(">");
            buf.append("<![CDATA[").append(params.get(key)).append("]]>");
            buf.append("</").append(key).append(">\n");
        }
        buf.append("</xmlbean>");
        return buf.toString();
    }

    /**
     * 异步通知报文转Map
     *
     * @param request
     * @param response
     * @param key
     */
    public static Map<String, String> notifyInfoToMapAndCheckSign(HttpServletRequest request, HttpServletResponse response, String key) {
        Map<String, String> map = Maps.newHashMap();
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            String resString = RequestUtils.parseRequst(request);
//            resString="";
            if (resString != null && !"".equals(resString)) {
                map = RequestUtils.toMap(resString.getBytes(), "utf-8");
                log.info("异步通知报文：" + resString);
//                if (map.containsKey("sign")) {
//                    if (!SignUtils.checkParam(map, key)) {
//                        throw new BusinessException("异步报文验签错误", ResultCodeEnum.EXECUTE_FAIL.getCode());
//                    }
//                } else {
//                    throw new BusinessException("异步报文缺少签名串", ResultCodeEnum.EXECUTE_FAIL.getCode());
//                }
            } else {
                throw new BusinessException("异步报文不能为空", ResultCodeEnum.EXECUTE_FAIL.getCode());
            }
            return map;
        } catch (Exception e) {
            throw new BusinessException("异步报文转化验签错误", ResultCodeEnum.EXECUTE_FAIL.getCode());
        }
    }

    /**
     * 异步通知报文转Map
     * @param request
     * @param response
     * @return
     */
    public static Map<String, String> notifyInfoToMapAndCheckSign(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = Maps.newHashMap();
        Map<String, String> headmap = Maps.newHashMap();
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            String resString = RequestUtils.parseRequst(request);
            log.info("平安银行子帐户交易推送通知报文:{}",resString);
            String str="<"+resString.split("<",2)[1];
            Document doc = DocumentHelper.parseText(str);
            //获取根目录
            Element rootEle = doc.getRootElement();
            //取得银行流水号
            Element bussFlowNo = rootEle.element("BODY");
            if (resString != null && !"".equals(resString)) {
                map = RequestUtils.toMap(bussFlowNo);
                //log.info("异步通知报文：" + str);

            } else {
                throw new BusinessException("异步报文不能为空", ResultCodeEnum.EXECUTE_FAIL.getCode());
            }

            Element sysHead = rootEle.element("SYS_HEAD");
            if (resString != null && !"".equals(resString)) {
                headmap = RequestUtils.toMap(sysHead);

            } else {
                throw new BusinessException("异步报文不能为空", ResultCodeEnum.EXECUTE_FAIL.getCode());
            }

            map.put("businessType", headmap.get("service_code"));//返回接口业务类型
            return map;
        } catch (Exception e) {
            throw new BusinessException("异步报文转化验签错误", ResultCodeEnum.EXECUTE_FAIL.getCode());
        }
    }

    /**
     * map转xml 字符串
     * @param map
     * @param sb
     */
    public static void mapToXML(Map map, StringBuffer sb) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value)
                value = "";
            if (value.getClass().getName().equals("java.util.ArrayList")) {
                ArrayList list = (ArrayList) map.get(key);
                sb.append("<" + key + ">\r\n");
                for (int i = 0; i < list.size(); i++) {
                    HashMap hm = (HashMap) list.get(i);
                    mapToXML(hm, sb);
                }
                sb.append("</" + key + ">\r\n");

            } else {
                if (value instanceof HashMap) {
                    sb.append("<" + key + ">\r\n");
                    mapToXML((HashMap) value, sb);
                    sb.append("</" + key + ">\r\n");
                } else if (value instanceof LinkedHashMap) {
                    sb.append("<" + key + ">\r\n");
                    mapToXML((LinkedHashMap) value, sb);
                    sb.append("</" + key + ">\r\n");
                } else {
                    sb.append("<" + key + ">" + value + "</" + key + ">\r\n");
                }

            }

        }
    }
    public static StringBuffer createStringBuffer(String encoding){
        StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\""+encoding+"\"?>\r\n");
        return sb;
    }

}
