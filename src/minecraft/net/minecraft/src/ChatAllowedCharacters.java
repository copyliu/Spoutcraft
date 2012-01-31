package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {
	public static final String allowedCharacters = getAllowedCharacters();
	public static final String originalCharacters = getOriginalCharacters();
	public static final char allowedCharactersArray[] = {
		'/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\',
		'<', '>', '|', '"', ':'
	};

	public ChatAllowedCharacters() {
	}

	private static String getOriginalCharacters() {
		String s = "";
		try {
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.ChatAllowedCharacters.class).getResourceAsStream("/font.txt"), "UTF-8"));
			String s1 = "";
			do {
				String s2;
				if ((s2 = bufferedreader.readLine()) == null) {
					break;
				}
				if (!s2.startsWith("#")) {
					s = (new StringBuilder()).append(s).append(s2).toString();
				}
			}
			while (true);
			bufferedreader.close();
		}
		catch (Exception exception) { }
		return s;
	}

	private static String getAddinCharacters() {
		String s = "";
		try {
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.ChatAllowedCharacters.class).getResourceAsStream("/addin.txt"), "UTF-8"));
			do {
				String s1;
				if ((s1 = bufferedreader.readLine()) == null) {
					break;
				}
				if (!s1.startsWith("#")) {
					s = (new StringBuilder()).append(s).append(s1).toString();
				}
			}
			while (true);
			bufferedreader.close();
		}
		catch (Exception exception) { }
		return s;
	}

	private static String getAllowedCharacters() {
		String s = "";
		s = (new StringBuilder()).append(getOriginalCharacters()).append(getAddinCharacters()).toString();
		return s;
	}
}
