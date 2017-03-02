package de.tud.gdi1.dungeonkeeper.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.Map;
import eea.engine.action.basicactions.ChangeStateAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.event.basicevents.KeyPressedEvent;

/**
 * @author Timo Bähr
 *
 * Diese Klasse repraesentiert das Spielfenster, indem ein Wassertropfen
 * erscheint und nach unten faellt.
 */
public class GameplayState extends BasicGameState {

	private int stateID; 							// Identifier dieses BasicGameState
	private StateBasedEntityManager entityManager; 	// zugehoeriger entityManager
	private int coreLife;
    
    GameplayState( int sid ) {
       stateID = sid;
       entityManager = StateBasedEntityManager.getInstance();
    }
    
    /**
     * Wird vor dem (erstmaligen) Starten dieses States ausgefuehrt
     */
    @Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	
    	// Hintergrund laden

    	Entity background = new Entity("background");	// Entitaet fuer Hintergrund
    	background.addComponent(new ImageRenderComponent(new Image("/assets/background.png"))); // Bildkomponente
    	background.setPosition(new Vector2f(DungeonKeeper.windowSize.x/2,DungeonKeeper.windowSize.y/2));	// Startposition des Hintergrunds
    	    	
    	// Hintergrund-Entitaet an StateBasedEntityManager uebergeben
    	StateBasedEntityManager.getInstance().addEntity(stateID, background);
		Map map = new Map(false, new int[]{13, 17}, new int[]{36, 9});
    	
    	// Bei Drücken der ESC-Taste zurueck ins Hauptmenue wechseln
    	Entity esc_Listener = new Entity("ESC_Listener");
    	KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
    	esc_pressed.addAction(new ChangeStateAction(DungeonKeeper.MAINMENU_STATE));
    	esc_Listener.addComponent(esc_pressed);    	
    	entityManager.addEntity(stateID, esc_Listener);   	
    }

    /**
     * Wird vor dem Frame ausgefuehrt
     */
    @Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// StatedBasedEntityManager soll alle Entities aktualisieren
    	entityManager.updateEntities(container, game, delta);
	}
    
    /**
     * Wird mit dem Frame ausgefuehrt
     */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// StatedBasedEntityManager soll alle Entities rendern
		entityManager.renderEntities(container, game, g);
		if (coreLife < 1)
		{
			//Game over logic
		}
	}

	@Override
	public int getID() {
		return stateID;
	}
}
