package com.user.servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@WebServlet("/fetchData")
public class APIServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String apiUrl = "http://127.0.0.1:5000/request/acctbook/query/xyzsdfg/9954000037?ab_type=&ar_type=";
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		conn.disconnect();
		
		JSONObject jsonObj = new JSONObject(content.toString());
		String newContent = jsonObj.get("res").toString();
		//content.getJSONObject("result").getJSONArray("entry");

// Parse JSON response
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Map<String, Object>>>() {
		}.getType();
		List<Map<String, Object>> dataList = gson.fromJson(newContent, listType);
		System.out.println(dataList.getFirst());
		//Post dataList = gson.fromJson(reader, Post.class);

// Forward data to JSP
		request.setAttribute("dataList", dataList.getFirst());
		//response.addCookie = "1";
		request.getRequestDispatcher("../bss/acct_book_query.jsp").forward(request,response);
	}
}