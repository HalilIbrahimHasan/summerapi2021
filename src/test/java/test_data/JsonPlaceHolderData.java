package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderData {


//    {
//             "userId": 21,
//            "title": "Wash the dishes",
//            "completed": false
//    }

    public Map<String, Object> expectedDataSetup(){

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",21 );
        expectedData.put("title","Wash the dishes");
        expectedData.put("completed",false);

        return expectedData;
    }

    public Map<String, Object> expectedDataSetup(int userId, String title, boolean isCompleted){

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",userId );
        expectedData.put("title",title);
        expectedData.put("completed",isCompleted);

        return expectedData;
    }
}
