package MyLibraries;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;

public class MyRequest {

    private JSONObject object;
    private JSONArray jArray;
    private String URL = "";
    private Context context;
    private Context tClass;
    private Map exceptionErrors = new HashMap<>();
    private JSONObject supObject;
    private Map<String,String> parameters;
    private String r;
    public MyRequest(String URL, Context context, Map<String,String> parameters){
        this.URL = URL;
        this.context = context;
        this.parameters = parameters;
    }

    public void makeRequest(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, this.URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                MyRequest.this.r = response;
                try {
                    JSONObject object = new JSONObject(response);
                    MyRequest.this.supObject = object;
                    final VolleyCallback Callback;
                    //Callback.onSuccessResponse(response);
                } catch (JSONException e) {
                    //error
                    exceptionErrors.put("EX_ERROR",true);
                    exceptionErrors.put("EXCEPTION",e.toString());
                    exceptionErrors.put("VOLLEY_ERROR",false);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                exceptionErrors.put("EX_ERROR",true);
                exceptionErrors.put("EXCEPTION",error.toString());
                exceptionErrors.put("VOLLEY_ERROR",true);
            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parameters;
            }
        };

        RequestQueue rq = Volley.newRequestQueue(this.context);
        rq.add(stringRequest);
    }


    public Map checkErrors()
    {
        return this.exceptionErrors;
    }

    public JSONObject myobj() {
        return this.supObject;
    }

    public String rr(){
        return  this.r;
    }

    public interface VolleyCallback {
        void onSuccessResponse(String response);
    }
}
