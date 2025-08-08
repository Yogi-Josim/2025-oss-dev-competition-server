package com.example.yogijosim.gpt;

import java.util.List;

public record GptRequestDto(
	String model,
	List<MessageDto> messages
) {
}