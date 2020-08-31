package com.jorge.testui.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-07-31 18:07
 */
@Getter
@Setter
public class AddApiRequestDocEvent {

    private Map<String , String> apiRequestDoc;
}
