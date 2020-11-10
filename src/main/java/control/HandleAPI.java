/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import data.JsonResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *
 * @author Admin
 */
public class HandleAPI {
    public static JsonResult getJsonData(String city){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        JsonResult data = null;
        Request res = new Request.Builder().url("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=77aaac25ee03de2a85a0cbf40589a56a&units=metric").build();
        try{
            Response response = client.newCall(res).execute();
            ResponseBody resbody = response.body();
            data = gson.fromJson(resbody.string(), JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
