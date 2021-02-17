package com.biss.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Ticket {
	@Id
	private String id;
	@NonNull
	private String code;
	@NonNull
	private Double cost;
	@NonNull
	private TicketInfo info;
	@NonNull
	private List<String> formats;
}
