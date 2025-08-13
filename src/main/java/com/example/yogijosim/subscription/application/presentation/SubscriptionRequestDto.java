package com.example.yogijosim.subscription.application.presentation;

import com.example.yogijosim.mail.MailFrequency;
import jakarta.validation.constraints.*;

import java.util.List;

public record SubscriptionRequestDto(
	@NotEmpty(message = "이메일은 비워둘 수 없습니다.")
	@Email(message = "올바른 이메일 형식이 아닙니다.")
	String email,

	@NotEmpty(message = "관심 지역을 하나 이상 선택해야 합니다.")
	List<String> regions,

	@NotEmpty(message = "메일 받을 주기를 선택해주세요.")
	MailFrequency frequency
) {
}
