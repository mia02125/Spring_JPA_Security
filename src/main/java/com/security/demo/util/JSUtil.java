package com.doosan.dls.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 		JSUtil.close(response);
		JSUtil.alert(response, "hihi");
		JSUtil.alert_back(response, "hihi");
		JSUtil.alert_replace(response, "hihi", "/");
 * */
public class JSUtil {


	public static void dev(HttpServletResponse response, HttpServletRequest request) throws IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Map<String, String[]> m = request.getParameterMap();
		Set<Entry<String, String[]>>  s = m.entrySet();

		Iterator<Entry<String, String[]>> it = s.iterator();

		while(it.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>)it.next();

			String key = entry.getKey();
			String[] value = entry.getValue();

			String skin1 = String.format("if %s", key);
			String skin2 = String.format("%s", key);

			String skin = skin2;

			StringBuffer sb = new StringBuffer(skin);


			pw.println(sb.toString());


            pw.println("<br>");
		}
		pw.close();
	}


	public static void failAlert(HttpServletResponse response, String message) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s'); </script>",  message);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void alert(HttpServletResponse response, String message) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s');</script>",  message);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(HttpServletResponse response) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> windows.close(); </script>");

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void alert_close(HttpServletResponse response, String message) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s'); window.close(); </script>",  message);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void alert_reload_close(HttpServletResponse response, String message) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s'); opener.location.reload(); window.close(); </script>",  message);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void alert_back(HttpServletResponse response, String message) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s'); history.back(); </script>",  message);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void alert_replace(HttpServletResponse response, String message, String url) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> alert('%s'); location.replace('%s'); </script>",  message, url);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void replace(HttpServletResponse response, String url) {

		response.setContentType("text/html; charset=UTF-8");
		String msg = String.format("<script> location.replace('%s'); </script>", url);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
