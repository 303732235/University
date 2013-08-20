package org.iti.common.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7609521898676321656L;

	public static class JsonException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7866686857232979501L;

		public JsonException(Throwable cause) {
			super(cause);
		}
	}

	/**
	 * �Ӷ���ת����json�ַ���
	 * 
	 * @param obj
	 * @return
	 */
	public static final String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * �����л�
	 * 
	 * @param clazz
	 *            Ŀ������
	 * @param json
	 *            json�ַ���
	 * @return
	 */
	public static final <T> T toObj(TypeToken<T> typeToken, String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, typeToken.getType());
	}

	/**
	 * �����л�
	 * 
	 * @param json
	 * @return
	 */
	public static <T> Collection<T> toCollection(String json,
			TypeToken<Collection<T>> typeToken) {
		return JsonUtil.toObj(typeToken, json);
	}

	/**
	 * �����л�
	 * 
	 * @param json
	 *            json�ַ���
	 * @return
	 */
	public static <T> List<T> toList(String json, TypeToken<List<T>> typeToken) {
		return JsonUtil.toObj(typeToken, json);
	}

	/**
	 * �����л�
	 * 
	 * @param json
	 *            json�ַ���
	 * @return
	 */
	public static <T> Set<T> toSet(String json, TypeToken<Set<T>> typeToken) {
		return JsonUtil.toObj(typeToken, json);
	}

	/**
	 * �����л�
	 * 
	 * @param json
	 *            json�ַ���
	 * @return
	 */
	public static <K, V> Map<K, V> toMap(String json,
			TypeToken<Map<K, V>> typeToken) {
		return JsonUtil.toObj(typeToken, json);
	}

	public static JsonObject parserToJsonObject(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(json);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		return jsonObject;
	}
}
