package io.application;

import java.util.HashMap;
import java.util.Map;

import io.gui.console.Console;
import io.gui.console.DisplayConsole;
import io.gui.console.ReadConsole;
import io.model.Emoji;
import io.util.EasterEggFileException;

public class ChocolateApplication {
		Console console;
		DisplayConsole display;
		ReadConsole read;
		Map<String, String> chocolateMenu;

		public ChocolateApplication() {
			this.console = new Console();
			this.display = new DisplayConsole();
			createChocolateMenu();
			this.read = new ReadConsole();			
		}

		public void aboutYourFavoriteChocolate() throws EasterEggFileException{

			console.title("Welcome ! What is your favourite chocolate ?");
			console.message(display.menu(chocolateMenu));
			
			console.message(" Your choice: ");
			console.lineBreak();
			int option = read.ensureIntegerBetween(display.exitKey(), chocolateMenu.size());
			
			answerChocolateMenuFor(option);

		}

		private void answerChocolateMenuFor(int option) throws EasterEggFileException{
			switch (option) {
			case 1:
				console.message(Emoji.CHOCOLATE_BAR.code() + " Healthy chocolate !" + Emoji.OK_HAND.code() + Emoji.THUMBS_UP.code());
				break;
			case 2:
				console.message(display.showContentFile("src/main/resources/easter.txt"));
				console.message(Emoji.CHOCOLATE_BAR.code()+ " The best chocolate for easter !" + Emoji.SMILING_FACE.code());
				//console.message("\ud83c\udf81");
				break;
			case 3:
				console.message(Emoji.CHOCOLATE_BAR.code() +" Sugar and fat : unhealthy !"+ Emoji.THUMBS_DOWN.code()+Emoji.GRINNING_FACE.code());
				break;
			default:
				console.message(Emoji.FACE_WITH_ROLLING_EYES.code()+" Maybe you dislike chocolate...");
				break;
			}
		}

		private void createChocolateMenu() {
			chocolateMenu = new HashMap<>();
			chocolateMenu.put("1", "Dark Chocolate");
			chocolateMenu.put("2", "Milk Chocolate");
			chocolateMenu.put("3", "White Chocolate");
		}

		public static void main(String[] args) {

			ChocolateApplication chocolateApplication= new ChocolateApplication();
			try {
				chocolateApplication.aboutYourFavoriteChocolate();
			} catch (EasterEggFileException e) {
				System.out.println("\ud83c\udf81");
			}
		}
	}