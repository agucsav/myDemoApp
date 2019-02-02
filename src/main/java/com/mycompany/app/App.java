package com.mycompany.app;

import java.util.ArrayList;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		port(getHerokuAssignedPort());

		get("/", (req, res) -> "Hello, World");

		post("/compute", (req, res) -> {
			// System.out.println(req.queryParams("input1"));
			// System.out.println(req.queryParams("input2"));

			String input1 = req.queryParams("input1");
			java.util.Scanner sc1 = new java.util.Scanner(input1);
			sc1.useDelimiter("[;\r\n]+");
			java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
			while (sc1.hasNext()) {
				int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
				inputList.add(value);
			}
			System.out.println(inputList);
			sc1.close();

			String input2 = req.queryParams("input2");
			java.util.Scanner sc2 = new java.util.Scanner(input2);
			sc1.useDelimiter("[;\r\n]+");
			java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
			while (sc2.hasNext()) {
				int value = Integer.parseInt(sc2.next().replaceAll("\\s", ""));
				inputList2.add(value);
			}
			System.out.println(inputList2);
			sc2.close();

			
			String input3 = req.queryParams("input3").replaceAll("\\s", "");
			int input3AsInt = Integer.parseInt(input3);
			

			String input4 = req.queryParams("input4").replaceAll("\\s", "");
			int input4AsInt = Integer.parseInt(input4);

			int computedValue = App.compute(inputList, inputList2, input3AsInt, input4AsInt);
			String result = "";
			if(computedValue == 1)
				result = "The sum of array1 is greater.";
			else if(computedValue == -1)
				result = "The sum of array2 is greater.";
			else if(computedValue == 0)
				result = "The sum of arrays are equal.";
			else
				result = "One of the array if empty.";
			Map map = new HashMap();
			map.put("result", result);
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());

		get("/compute", (rq, rs) -> {
			Map map = new HashMap();
			map.put("result", "not computed yet!");
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());

	}

	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


	public static int compute(ArrayList<Integer> array1,ArrayList<Integer> array2, int e, int e2) {
		System.out.println("inside compute");
		if (array1 == null|| array2== null)
			return -2;
		
		int arraySum1 = 0;
		int arraySum2 = 0;
		for (int elt : array1) {
			if (elt == e) {
				for (int ele : array1)
					ele = ele*e;
				break;
			}
		}
		for (int elt : array1) {
			arraySum1 = arraySum1 + elt;
		}
		
		
		for (int elt : array2) {
			if (elt == e2) {
				for (int ele : array2)
					ele = ele*e2;
				break;
			}
		}
		
		for (int elt : array2) {
			arraySum2 = arraySum2 + elt;
		}
		
		if(arraySum1> arraySum2) {
			return 1;
			
		}
		else if(arraySum1< arraySum2) {
			return -1;
		}
		return 0;
	}
}
