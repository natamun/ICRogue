NAME		= icrogue

SRC_DIR		= src

SRCS		= $(SRC_DIR)/icrogue/Play.java \
			  $(SRC_DIR)/icrogue/game/DragHelper.java \
			  $(SRC_DIR)/icrogue/game/Game.java \
			  $(SRC_DIR)/icrogue/game/PauseMenu.java \
			  $(SRC_DIR)/icrogue/game/Playable.java \
			  $(SRC_DIR)/icrogue/game/Updatable.java \
			  $(SRC_DIR)/icrogue/game/actor/Acoustics.java \
			  $(SRC_DIR)/icrogue/game/actor/Actor.java \
			  $(SRC_DIR)/icrogue/game/actor/Draggable.java \
			  $(SRC_DIR)/icrogue/game/actor/Droppable.java \
			  $(SRC_DIR)/icrogue/game/actor/Entity.java \
			  $(SRC_DIR)/icrogue/game/actor/Graphics.java \
			  $(SRC_DIR)/icrogue/game/actor/GraphicsEntity.java \
			  $(SRC_DIR)/icrogue/game/actor/ImageGraphics.java \
			  $(SRC_DIR)/icrogue/game/actor/ShapeGraphics.java \
			  $(SRC_DIR)/icrogue/game/actor/SoundAcoustics.java \
			  $(SRC_DIR)/icrogue/game/actor/TextGraphics.java \
			  $(SRC_DIR)/icrogue/game/areagame/Area.java \
			  $(SRC_DIR)/icrogue/game/areagame/AreaBehavior.java \
			  $(SRC_DIR)/icrogue/game/areagame/AreaGame.java \
			  $(SRC_DIR)/icrogue/game/areagame/AreaGraph.java \
			  $(SRC_DIR)/icrogue/game/areagame/AreaPauseMenu.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Animation.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/AreaEntity.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Background.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/CellMouseIndicator.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/CollectableAreaEntity.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/DraggableAreaEntity.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Foreground.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Grid.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Interactable.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Interactor.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/MovableAreaEntity.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Orientation.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Path.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Sprite.java \
			  $(SRC_DIR)/icrogue/game/areagame/actor/Text.java \
			  $(SRC_DIR)/icrogue/game/areagame/handler/AreaInteractionVisitor.java \
			  $(SRC_DIR)/icrogue/game/areagame/io/ResourcePath.java \
			  $(SRC_DIR)/icrogue/game/icrogue/ICRogue.java \
			  $(SRC_DIR)/icrogue/game/icrogue/ICRogueBehavior.java \
			  $(SRC_DIR)/icrogue/game/icrogue/ICRogueKeybinds.java \
			  $(SRC_DIR)/icrogue/game/icrogue/MenuScreens/ICRogueGameOverMenu.java \
			  $(SRC_DIR)/icrogue/game/icrogue/MenuScreens/ICRoguePauseMenu.java \
			  $(SRC_DIR)/icrogue/game/icrogue/MenuScreens/ICRogueWonMenu.java \
			  $(SRC_DIR)/icrogue/game/icrogue/RandomHelper.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/Connector.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/ICRogueActor.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/ICRogueGraphics.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/ICRoguePlayer.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/enemies/DarkLord.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/enemies/Enemy.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/enemies/FlameSkull.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/enemies/Turret.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/friendlyNPC/NinjaPNJ.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/Cherry.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/FireStaff.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/Heart.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/Item.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/Key.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/PlayerUsingWeapon.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/WaterStaff.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/items/Weapon.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/projectiles/Arrow.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/projectiles/Consumable.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/projectiles/FireBall.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/projectiles/Projectile.java \
			  $(SRC_DIR)/icrogue/game/icrogue/actor/projectiles/WaterBall.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/ConnectorInRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/ICRogueRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/Level.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/Level0.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0BossRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0CherryRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0EnemyRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0FireStaffRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0ItemRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0KeyRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0Room.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0TurretRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/area/level0/rooms/Level0WaterStaffRoom.java \
			  $(SRC_DIR)/icrogue/game/icrogue/handler/ICRogueInteractionHandler.java \
			  $(SRC_DIR)/icrogue/io/DefaultFileSystem.java \
			  $(SRC_DIR)/icrogue/io/FileSystem.java \
			  $(SRC_DIR)/icrogue/io/FolderFileSystem.java \
			  $(SRC_DIR)/icrogue/io/ResourceFileSystem.java \
			  $(SRC_DIR)/icrogue/io/XMLTexts.java \
			  $(SRC_DIR)/icrogue/io/ZipFileSystem.java \
			  $(SRC_DIR)/icrogue/math/Attachable.java \
			  $(SRC_DIR)/icrogue/math/Circle.java \
			  $(SRC_DIR)/icrogue/math/DiscreteCoordinates.java \
			  $(SRC_DIR)/icrogue/math/Node.java \
			  $(SRC_DIR)/icrogue/math/Polygon.java \
			  $(SRC_DIR)/icrogue/math/Polyline.java \
			  $(SRC_DIR)/icrogue/math/Positionable.java \
			  $(SRC_DIR)/icrogue/math/RandomEvent.java \
			  $(SRC_DIR)/icrogue/math/RandomGenerator.java \
			  $(SRC_DIR)/icrogue/math/RegionOfInterest.java \
			  $(SRC_DIR)/icrogue/math/Shape.java \
			  $(SRC_DIR)/icrogue/math/TextAlign.java \
			  $(SRC_DIR)/icrogue/math/Transform.java \
			  $(SRC_DIR)/icrogue/math/Vector.java \
			  $(SRC_DIR)/icrogue/recorder/Record.java \
			  $(SRC_DIR)/icrogue/recorder/RecordReplayer.java \
			  $(SRC_DIR)/icrogue/recorder/Recorder.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/KeyboardPressedRecordEntry.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/KeyboardReleasedRecordEntry.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/MouseButtonPressedRecordEntry.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/MouseButtonReleasedRecordEntry.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/MouseMoveRecordEntry.java \
			  $(SRC_DIR)/icrogue/recorder/recordEntry/RecordEntry.java \
			  $(SRC_DIR)/icrogue/signal/Numeric.java \
			  $(SRC_DIR)/icrogue/signal/Signal.java \
			  $(SRC_DIR)/icrogue/signal/logic/And.java \
			  $(SRC_DIR)/icrogue/signal/logic/Logic.java \
			  $(SRC_DIR)/icrogue/signal/logic/LogicGate.java \
			  $(SRC_DIR)/icrogue/signal/logic/LogicNumber.java \
			  $(SRC_DIR)/icrogue/signal/logic/MultipleAnd.java \
			  $(SRC_DIR)/icrogue/signal/logic/Nand.java \
			  $(SRC_DIR)/icrogue/signal/logic/Not.java \
			  $(SRC_DIR)/icrogue/signal/logic/Or.java \
			  $(SRC_DIR)/icrogue/signal/logic/Xor.java \
			  $(SRC_DIR)/icrogue/signal/wave/Sawtooth.java \
			  $(SRC_DIR)/icrogue/signal/wave/Sine.java \
			  $(SRC_DIR)/icrogue/signal/wave/Square.java \
			  $(SRC_DIR)/icrogue/signal/wave/Triangle.java \
			  $(SRC_DIR)/icrogue/signal/wave/Waveform.java \
			  $(SRC_DIR)/icrogue/window/Audio.java \
			  $(SRC_DIR)/icrogue/window/Button.java \
			  $(SRC_DIR)/icrogue/window/Canvas.java \
			  $(SRC_DIR)/icrogue/window/Image.java \
			  $(SRC_DIR)/icrogue/window/Keyboard.java \
			  $(SRC_DIR)/icrogue/window/Mouse.java \
			  $(SRC_DIR)/icrogue/window/Sound.java \
			  $(SRC_DIR)/icrogue/window/Window.java \
			  $(SRC_DIR)/icrogue/window/swing/ImageItem.java \
			  $(SRC_DIR)/icrogue/window/swing/Item.java \
			  $(SRC_DIR)/icrogue/window/swing/ShapeItem.java \
			  $(SRC_DIR)/icrogue/window/swing/SoundItem.java \
			  $(SRC_DIR)/icrogue/window/swing/SwingImage.java \
			  $(SRC_DIR)/icrogue/window/swing/SwingSound.java \
			  $(SRC_DIR)/icrogue/window/swing/SwingWindow.java \
			  $(SRC_DIR)/icrogue/window/swing/TextItem.java

RES_DIR		= res
OUT_DIR		= out

MAIN_CLASS	= icrogue.Play

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
