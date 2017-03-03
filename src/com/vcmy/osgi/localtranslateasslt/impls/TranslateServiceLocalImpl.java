package com.vcmy.osgi.localtranslateasslt.impls;

import java.util.concurrent.ConcurrentHashMap;

import com.vcmy.osgi.translateasslt.service.TranslateService;

public class TranslateServiceLocalImpl implements TranslateService{

	//由于程序侧重解决大规模并发访问问题，所以采取并发包：
	//java.util.concurrent中的ConcurrentHashMap来存储对象
	private static final ConcurrentHashMap<String, String> dictonary =
			new ConcurrentHashMap<String, String>();
	
	static{
		dictonary.put("China", "中国");
		dictonary.put("USA", "美国");
	}
	
	@Override
	public String translate(String word) {
		System.out.println("LocalTranslateAasslt Service...");
		String result = dictonary.get(word);
		if(null == result){
			result = "未找到您所查单词意以，请检查单词是否正确！";
		}
		
		return result;
	}

}
