package com.yc.mybatis;

import org.apache.commons.text.StringEscapeUtils;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 14:48 2023/8/9
 */
public class test {

    public static void main(String[] args) {
        String a="&#24744;&#22909;&#65281;&#40635;&#28902;&#24744;&#25277;2&#20998;&#38047;&#26102;&#38388;&#65292;&#22635;&#20889;&#19979;&#38543;&#35775;&#20449;&#24687;&#65292;&#35874;&#35874;&#65281;";

        String b = "&amp;lt;h3&amp;gt;&amp;lt;em&amp;gt;半流质饮食，以稀粥、面条等为主；&amp;lt;/em&amp;gt;&amp;lt;/h3&amp;gt;";
        System.out.println(StringEscapeUtils.unescapeHtml4(a));


        String doubleEscapedText = "&amp;lt;h3&amp;gt;&amp;lt;em&amp;gt;半流质饮食,以稀粥、面条等为主;&amp;lt;/em&amp;gt;&amp;lt;/h3&amp;gt;";

        String singleEscapedText = doubleEscapedText.replace("&amp;lt;", "&lt;").replace("&amp;gt;", "&gt;");

        String unescapedText = StringEscapeUtils.unescapeHtml4(singleEscapedText);

        System.out.println(unescapedText);
    }
}
