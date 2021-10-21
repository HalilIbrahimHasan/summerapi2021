package data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderData {


    public Map<String, Object> bodySetup(){

        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("userId",21);
        bodyRequest.put("title","Wash the dishes");
        bodyRequest.put("completed",false);

        return bodyRequest;

    }

    public Map<String, Object> bodySetup(int userId,String title,boolean completed){

        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("userId",21);
        bodyRequest.put("title","Wash the dishes");
        bodyRequest.put("completed",false);

        return bodyRequest;

    }

}
