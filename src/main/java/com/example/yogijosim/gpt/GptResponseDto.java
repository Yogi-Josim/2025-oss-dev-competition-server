package com.example.yogijosim.gpt;

import java.util.List;

public record GptResponseDto(
    List<Choice> choices
) {}

record Choice(
    MessageDto message
) {}