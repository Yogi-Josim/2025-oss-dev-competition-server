package com.example.yogijosim.gpt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GptService {
	private final WebClient webClient;
	private final ObjectMapper objectMapper;

	private static final String SYSTEM_PROMPT = """
		너는 한국의 온라인 커뮤니티 게시글을 분석하여 사건/사고 정보를 추출하는 전문가야.
		주어진 텍스트에서 중요한 사건 정보를 추출하고, 반드시 다음 JSON 형식에 맞춰서 답변해줘.
		{
		  "summary": "사건을 한 줄로 요약",
		  "category": "NATURAL_DISASTER, VIOLENT_CRIME, SUBWAY_FIRE, PEST_OUTBREAK, SINKHOLE, ACCIDENT, ETC 중 하나",
		  "location": "최대한 구체적인 발생 지역",
		  "danger_level": "사건의 위험도를 1에서 5 사이의 숫자로 평가",
		  "reliability": "내용의 신뢰도를 1에서 5 사이의 숫자로 평가"
		}
		  만약 텍스트가 사건/사고와 관련이 없다면, summary와 location은 "N/A"로, danger_level과 reliability는 0으로, category는 "ETC"로 채워서 답변해줘.
		""";
	private static final String model = "gpt-5-mini";

	public IncidentAnalysisDto analyze(String rawContent) {
		List<MessageDto> messages = List.of(
			new MessageDto("system", SYSTEM_PROMPT),
			new MessageDto("user", rawContent)
		);
		GptRequestDto request = new GptRequestDto(model, messages);

		try {
			GptResponseDto response = webClient.post()
				.uri("/chat/completions")
				.bodyValue(request)
				.retrieve()
				.bodyToMono(GptResponseDto.class)
				.block();

			if (response == null || response.choices().isEmpty()) {
				throw new RuntimeException("GPT API로부터 유효한 응답을 받지 못했습니다.");
			}

			String jsonContent = response.choices().get(0).message().content();

			// GPT가 코드블록(```json ... ```)으로 답변하는 경우가 있어 제거
			jsonContent = jsonContent.replace("```json", "").replace("```", "").trim();

			return objectMapper.readValue(jsonContent, IncidentAnalysisDto.class);

		} catch (Exception e) {
			log.error("GPT 분석 중 오류 발생: {}", e.getMessage());
			throw new RuntimeException("GPT 분석에 실패했습니다.", e);
		}
	}
}
