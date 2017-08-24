package com.hxs.sms.model;

import java.util.Date;
import java.util.UUID;

import com.hxs.sms.util.json.JsonDateTimeSerializer;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Data
public class BaseModel {
	private Integer seqNo;

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	private Date createTime;

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	private Date updateTime;

	private String creator;

	private String updateBy;

	public static String newId() {
		return DigestUtils.md5Hex(UUID.randomUUID().toString());
	}
}
