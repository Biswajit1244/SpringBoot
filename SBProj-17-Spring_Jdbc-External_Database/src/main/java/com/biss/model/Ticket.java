package com.biss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Ticket {
	@NonNull
	private Integer tickId;
	@NonNull
	private Integer code;
	@NonNull
	private Float fare;
	@NonNull
	private Float gst;
	private Float total;
}
