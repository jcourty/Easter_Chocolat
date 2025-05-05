package io.model;

public enum Emoji {
	THUMBS_UP("\uD83D\uDC4D"),
	THUMBS_DOWN("\uD83D\uDC4E"),
	OK_HAND("\uD83D\uDC4C"),
	CHOCOLATE_BAR("\uD83C\uDF6B"),
	SMILING_FACE("\u263A"),
	GRINNING_FACE("\uD83E\uDD2A"),
	FACE_WITH_ROLLING_EYES("\uD83D\uDE44");
	
	private String code;
	
	private Emoji(String code) {
		this.code = code;
	}

	public String code(){
		return this.code;
	}
}