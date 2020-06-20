package com.jldubz.gistaviewer.viewmodel;

import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

import okhttp3.Headers;
import retrofit2.Response;


public class NetworkUtil {
    public static String onGitHubResponseError(Response response) {

        if (response.code() == 403){

            Headers headers = response.headers();

            Set<String> headerNames = headers.names();
            long rateLimitReset = 0;

            for (String headerName:
                 headerNames) {
                String headerValue = headers.get(headerName);
                if (headerValue == null) {
                    continue;
                }

                if (headerName.equals("X-rateLimit-Reset")){
                    rateLimitReset = Long.valueOf(headers.get(headerName));
                    break;
                }
                
            }

            if (rateLimitReset !=0){
                Date ResetDate = new Date(rateLimitReset * 1000);
                DateFormat dateFormat;
                String resetTimeText = DateFormat.getTimeInstance().format(ResetDate);

                return "uh looks likes you exceeds API limit" + resetTimeText;
            }

        }

        return response.message();
    }
}
