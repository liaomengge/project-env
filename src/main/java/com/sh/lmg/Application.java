package com.sh.lmg;

import com.sh.lmg.util.PropertiesUtil;

/**
 * Created by liaomengge on 16/4/21.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("current env is : " + PropertiesUtil.getStringProperty("app.env"));
    }
}
