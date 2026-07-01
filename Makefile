NAME		= icrogue

SRC_DIR		= src/main/java

SRCS		= $(SRC_DIR)/ch/epfl/cs107/play/Play.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/DragHelper.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/Game.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/PauseMenu.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/Playable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/Updatable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Acoustics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Actor.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Draggable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Droppable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Entity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/Graphics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/GraphicsEntity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/ImageGraphics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/ShapeGraphics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/SoundAcoustics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/actor/TextGraphics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/Area.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/AreaBehavior.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/AreaGame.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/AreaGraph.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/AreaPauseMenu.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Animation.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/AreaEntity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Background.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/CellMouseIndicator.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/CollectableAreaEntity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/DraggableAreaEntity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Foreground.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Grid.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Interactable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Interactor.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/MovableAreaEntity.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Orientation.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Path.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Sprite.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/actor/Text.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/handler/AreaInteractionVisitor.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/areagame/io/ResourcePath.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/ICRogue.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/ICRogueBehavior.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/ICRogueKeybinds.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/MenuScreens/ICRogueGameOverMenu.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/MenuScreens/ICRoguePauseMenu.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/MenuScreens/ICRogueWonMenu.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/RandomHelper.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/Connector.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/ICRogueActor.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/ICRogueGraphics.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/ICRoguePlayer.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/enemies/DarkLord.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/enemies/Enemy.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/enemies/FlameSkull.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/enemies/Turret.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/friendlyNPC/NinjaPNJ.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/Cherry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/FireStaff.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/Heart.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/Item.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/Key.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/PlayerUsingWeapon.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/WaterStaff.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/items/Weapon.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/projectiles/Arrow.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/projectiles/Consumable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/projectiles/FireBall.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/projectiles/Projectile.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/actor/projectiles/WaterBall.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/ConnectorInRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/ICRogueRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/Level.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/Level0.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0BossRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0CherryRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0EnemyRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0FireStaffRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0ItemRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0KeyRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0Room.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0TurretRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/area/level0/rooms/Level0WaterStaffRoom.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/game/icrogue/handler/ICRogueInteractionHandler.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/DefaultFileSystem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/FileSystem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/FolderFileSystem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/ResourceFileSystem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/XMLTexts.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/io/ZipFileSystem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Attachable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Circle.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/DiscreteCoordinates.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Node.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Polygon.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Polyline.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Positionable.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/RandomEvent.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/RandomGenerator.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/RegionOfInterest.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Shape.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/TextAlign.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Transform.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/math/Vector.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/Record.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/RecordReplayer.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/Recorder.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/KeyboardPressedRecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/KeyboardReleasedRecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/MouseButtonPressedRecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/MouseButtonReleasedRecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/MouseMoveRecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/recorder/recordEntry/RecordEntry.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/Numeric.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/Signal.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/And.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/Logic.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/LogicGate.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/LogicNumber.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/MultipleAnd.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/Nand.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/Not.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/Or.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/logic/Xor.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/wave/Sawtooth.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/wave/Sine.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/wave/Square.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/wave/Triangle.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/signal/wave/Waveform.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Audio.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Button.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Canvas.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Image.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Keyboard.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Mouse.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Sound.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/Window.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/ImageItem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/Item.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/ShapeItem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/SoundItem.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/SwingImage.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/SwingSound.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/SwingWindow.java \
			  $(SRC_DIR)/ch/epfl/cs107/play/window/swing/TextItem.java

RES_DIR		= src/main/res
OUT_DIR		= out

MAIN_CLASS	= ch.epfl.cs107.play.Play

JAVAC		= javac
JAVACFLAGS	= -d $(OUT_DIR) -encoding UTF-8
RM		= rm -f

all: $(NAME)

$(NAME): $(SRCS)
	@echo "Compiling $(NAME)..."
	@mkdir -p $(OUT_DIR)
	@$(JAVAC) $(JAVACFLAGS) $(SRCS)
	@echo '#!/usr/bin/env bash' > $(NAME)
	@echo 'java -cp "$(OUT_DIR):$(RES_DIR)" $(MAIN_CLASS) "$$@"' >> $(NAME)
	@chmod +x $(NAME)
	@echo "Build complete! Run with ./$(NAME)"

run: $(NAME)
	./$(NAME)

clean:
	@echo "Cleaning compiled classes..."
	@$(RM) -r $(OUT_DIR)
	@echo "Clean done."

fclean: clean
	@echo "Removing $(NAME)..."
	@$(RM) $(NAME)
	@echo "Full clean done."

re: fclean all

.PHONY: all run clean fclean re
