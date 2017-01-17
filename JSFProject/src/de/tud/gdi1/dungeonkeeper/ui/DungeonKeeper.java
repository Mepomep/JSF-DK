package de.tud.gdi1.dungeonkeeper.ui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.entity.StateBasedEntityManager;

/**
 * @author Timo Bähr
 *
 *         Diese Klasse startet das Spiel "Drop of Water". Es enthaelt zwei
 *         State's für das Menue und das eigentliche Spiel.
 */
public class DungeonKeeper extends StateBasedGame {

	// Jeder State wird durch einen Integer-Wert gekennzeichnet
	public static final int MAINMENU_STATE = 0;
	public static final int GAMEPLAY_STATE = 1;

	public DungeonKeeper() {
		super("Drop of Water");
	}

	public static void main(String[] args) throws SlickException {
		// Set the library path depending on the OS
		if (System.getProperty("os.name").toLowerCase().contains("windows"))
			System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/windows");
		else if (System.getProperty("os.name").toLowerCase().contains("mac"))
			System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/macosx");
		else
			System.setProperty("org.lwjgl.librarypath",
					System.getProperty("user.dir") + "/native/" + System.getProperty("os.name").toLowerCase());

		// Setze dieses StateBasedGame in einen App Container (oder Fenster)
		AppGameContainer app = new AppGameContainer(new DungeonKeeper());

		// Lege die Einstellungen des Fensters fest und starte das Fenster
		// (nicht aber im Vollbildmodus)
		app.setDisplayMode(1680, 1050, true);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {

		// Fuege dem StateBasedGame die States hinzu
		// (der zuerst hinzugefuegte State wird als erster State gestartet)
		addState(new MainMenuState(MAINMENU_STATE));
		addState(new GameplayState(GAMEPLAY_STATE));

		// Fuege dem StateBasedEntityManager die States hinzu
		StateBasedEntityManager.getInstance().addState(MAINMENU_STATE);
		StateBasedEntityManager.getInstance().addState(GAMEPLAY_STATE);

	}
}