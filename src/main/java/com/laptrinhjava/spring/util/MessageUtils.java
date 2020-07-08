package com.laptrinhjava.spring.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("insert_success")) {
			result.put("messageResponse", "Thêm mới thành công");
			result.put("alert", "success");
		} else if (message.equals("update_success")) {
			result.put("messageResponse", "Cập nhật thành công");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("messageResponse", "Xóa thành công");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("messageResponse", "Lỗi hệ thống");
			result.put("alert", "danger");
		}
		
		return result;
	}
}
