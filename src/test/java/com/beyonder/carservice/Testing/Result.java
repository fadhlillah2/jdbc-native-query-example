package com.beyonder.carservice.Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class Result {

    /*
     * Complete the 'getAuthorHistory' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * Base urls:
     *   https://jsonmock.hackerrank.com/api/article_users?username=
     *   https://jsonmock.hackerrank.com/api/articles?author=
     *
     */
    public static void main(String[] args) {
        System.out.println();
        getAuthorHistory("ega");
    }

    public static List<String> getAuthorHistory(String author) {
        try{

            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author=epaga");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code" + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while((inputLine = in.readLine())!=null){
                    response.append(inputLine);
                }
                in.close();

                System.out.println("data: "+ response.toString());
//                JSONObject obj = new JSONObject(response.toString());
//                JSONArray data = obj.getJSONArray("data");
//
//                for (int i = 0; i < data.length(); i++) {
//                    JSONObject dataObj = data.getJSONObject(i);
//                    String title = dataObj.getString("title");
//                    String url = dataObj.getString("url");
//                    // Continue for all the properties you want to extract
//                    System.out.println("Title: " + title);
//                    System.out.println("URL: " + url);
//                    System.out.println();
//                }

            } else {
                System.out.println("Get Request failed");
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}

//class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String author = bufferedReader.readLine();
//
//        List<String> result = Result.getAuthorHistory(author);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
