package com.example.job.config;

import com.example.job.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@Slf4j
@Component
public class UserIdentManager {
    private Map<String, Function<Map<String, User>, Map<String, User>>> fieldToFuncMap;



    public UserIdentManager() {
        fieldToFuncMap = new HashMap<>();
        fieldToFuncMap.putIfAbsent("abc", this::fillIdentInfo);
    }


    private Map<String, User> fillIdentInfo(Map<String, User> map) {

        User userName = User.builder().email("aaa@qq.com").idCard("456***987").phone("12387653333").userName("黎明").build();
        map.put("ceshi", userName);
        return map;
    }


    private Map<String, Function<Map<String, User>, Map<String, User>>> getFunctionMapFromFields(List<String> fields) {
        Map<String, Function<Map<String, User>, Map<String, User>>> functionMap = new HashMap<>(fieldToFuncMap.size());
        for (String fieldName : fields) {
            if (fieldToFuncMap.containsKey(fieldName)) {
                functionMap.putIfAbsent(fieldName, fieldToFuncMap.get(fieldName));
            }
        }
        return functionMap;
    }


    private Map<String, User> formatValiStatus(List<String> fields,
                                               Map<String, User> arrUserInfo,
                                               Map<String, Function<Map<String, User>, Map<String, User>>> functionMap) {
        if (fields.contains("abc")) {
            Function<Map<String, User>, Map<String, User>> function
                    = functionMap.get("abc");
            arrUserInfo = function.apply(arrUserInfo);
        }
        return arrUserInfo;
    }


    public  Map<String, User> a() {
        List<String> fields = new ArrayList<>();
        fields.add("abc");
        Map<String, User> userInfoMap = new HashMap<>();
        Map<String, Function<Map<String, User>, Map<String, User>>> functionMap = getFunctionMapFromFields(fields);

        //step1:优先处理vali_status
        Map<String, User> stringUserMap = userInfoMap = formatValiStatus(fields, userInfoMap, functionMap);
        return stringUserMap;

    }

}
