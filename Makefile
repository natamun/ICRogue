NAME		= icrogue

SRC_DIR		= src

SRCS		= $(SRC_DIR)/icrogue/ICRogue.java \
			  $(SRC_DIR)/icrogue/ICRogueBehavior.java \
			  $(SRC_DIR)/icrogue/ICRogueKeybinds.java \
			  $(SRC_DIR)/icrogue/MenuScreens/ICRogueGameOverMenu.java \
			  $(SRC_DIR)/icrogue/MenuScreens/ICRoguePauseMenu.java \
			  $(SRC_DIR)/icrogue/MenuScreens/ICRogueWonMenu.java \
			  $(SRC_DIR)/icrogue/Play.java \
			  $(SRC_DIR)/icrogue/RandomHelper.java \
			  $(SRC_DIR)/icrogue/actor/Connector.java \
			  $(SRC_DIR)/icrogue/actor/ICRogueActor.java \
			  $(SRC_DIR)/icrogue/actor/ICRogueGraphics.java \
			  $(SRC_DIR)/icrogue/actor/ICRoguePlayer.java \
			  $(SRC_DIR)/icrogue/actor/enemies/DarkLord.java \
			  $(SRC_DIR)/icrogue/actor/enemies/Enemy.java \
			  $(SRC_DIR)/icrogue/actor/enemies/FlameSkull.java \
			  $(SRC_DIR)/icrogue/actor/enemies/Turret.java \
			  $(SRC_DIR)/icrogue/actor/friendlyNPC/NinjaPNJ.java \
			  $(SRC_DIR)/icrogue/actor/items/Cherry.java \
			  $(SRC_DIR)/icrogue/actor/items/FireStaff.java \
			  $(SRC_DIR)/icrogue/actor/items/Heart.java \
			  $(SRC_DIR)/icrogue/actor/items/Item.java \
			  $(SRC_DIR)/icrogue/actor/items/Key.java \
			  $(SRC_DIR)/icrogue/actor/items/PlayerUsingWeapon.java \
			  $(SRC_DIR)/icrogue/actor/items/WaterStaff.java \
			  $(SRC_DIR)/icrogue/actor/items/Weapon.java \
			  $(SRC_DIR)/icrogue/actor/projectiles/Arrow.java \
			  $(SRC_DIR)/icrogue/actor/projectiles/Consumable.java \
			  $(SRC_DIR)/icrogue/actor/projectiles/FireBall.java \
			  $(SRC_DIR)/icrogue/actor/projectiles/Projectile.java \
			  $(SRC_DIR)/icrogue/actor/projectiles/WaterBall.java \
			  $(SRC_DIR)/icrogue/area/ConnectorInRoom.java \
			  $(SRC_DIR)/icrogue/area/ICRogueRoom.java \
			  $(SRC_DIR)/icrogue/area/Level.java \
			  $(SRC_DIR)/icrogue/area/level0/Level0.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0BossRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0CherryRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0EnemyRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0FireStaffRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0ItemRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0KeyRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0Room.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0TurretRoom.java \
			  $(SRC_DIR)/icrogue/area/level0/rooms/Level0WaterStaffRoom.java \
			  $(SRC_DIR)/icrogue/engine/game/DragHelper.java \
			  $(SRC_DIR)/icrogue/engine/game/Game.java \
			  $(SRC_DIR)/icrogue/engine/game/PauseMenu.java \
			  $(SRC_DIR)/icrogue/engine/game/Playable.java \
			  $(SRC_DIR)/icrogue/engine/game/Updatable.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Acoustics.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Actor.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Draggable.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Droppable.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Entity.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/Graphics.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/GraphicsEntity.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/ImageGraphics.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/ShapeGraphics.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/SoundAcoustics.java \
			  $(SRC_DIR)/icrogue/engine/game/actor/TextGraphics.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/Area.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/AreaBehavior.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/AreaGame.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/AreaGraph.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/AreaPauseMenu.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Animation.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/AreaEntity.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Background.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/CellMouseIndicator.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/CollectableAreaEntity.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/DraggableAreaEntity.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Foreground.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Grid.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Interactable.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Interactor.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/MovableAreaEntity.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Orientation.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Path.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Sprite.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/actor/Text.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/handler/AreaInteractionVisitor.java \
			  $(SRC_DIR)/icrogue/engine/game/areagame/io/ResourcePath.java \
			  $(SRC_DIR)/icrogue/engine/io/DefaultFileSystem.java \
			  $(SRC_DIR)/icrogue/engine/io/FileSystem.java \
			  $(SRC_DIR)/icrogue/engine/io/FolderFileSystem.java \
			  $(SRC_DIR)/icrogue/engine/io/ResourceFileSystem.java \
			  $(SRC_DIR)/icrogue/engine/io/XMLTexts.java \
			  $(SRC_DIR)/icrogue/engine/io/ZipFileSystem.java \
			  $(SRC_DIR)/icrogue/engine/math/Attachable.java \
			  $(SRC_DIR)/icrogue/engine/math/Circle.java \
			  $(SRC_DIR)/icrogue/engine/math/DiscreteCoordinates.java \
			  $(SRC_DIR)/icrogue/engine/math/Node.java \
			  $(SRC_DIR)/icrogue/engine/math/Polygon.java \
			  $(SRC_DIR)/icrogue/engine/math/Polyline.java \
			  $(SRC_DIR)/icrogue/engine/math/Positionable.java \
			  $(SRC_DIR)/icrogue/engine/math/RandomEvent.java \
			  $(SRC_DIR)/icrogue/engine/math/RandomGenerator.java \
			  $(SRC_DIR)/icrogue/engine/math/RegionOfInterest.java \
			  $(SRC_DIR)/icrogue/engine/math/Shape.java \
			  $(SRC_DIR)/icrogue/engine/math/TextAlign.java \
			  $(SRC_DIR)/icrogue/engine/math/Transform.java \
			  $(SRC_DIR)/icrogue/engine/math/Vector.java \
			  $(SRC_DIR)/icrogue/engine/recorder/Record.java \
			  $(SRC_DIR)/icrogue/engine/recorder/RecordReplayer.java \
			  $(SRC_DIR)/icrogue/engine/recorder/Recorder.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/KeyboardPressedRecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/KeyboardReleasedRecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/MouseButtonPressedRecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/MouseButtonReleasedRecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/MouseMoveRecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/recorder/recordEntry/RecordEntry.java \
			  $(SRC_DIR)/icrogue/engine/signal/Numeric.java \
			  $(SRC_DIR)/icrogue/engine/signal/Signal.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/And.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/Logic.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/LogicGate.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/LogicNumber.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/MultipleAnd.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/Nand.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/Not.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/Or.java \
			  $(SRC_DIR)/icrogue/engine/signal/logic/Xor.java \
			  $(SRC_DIR)/icrogue/engine/signal/wave/Sawtooth.java \
			  $(SRC_DIR)/icrogue/engine/signal/wave/Sine.java \
			  $(SRC_DIR)/icrogue/engine/signal/wave/Square.java \
			  $(SRC_DIR)/icrogue/engine/signal/wave/Triangle.java \
			  $(SRC_DIR)/icrogue/engine/signal/wave/Waveform.java \
			  $(SRC_DIR)/icrogue/engine/window/Audio.java \
			  $(SRC_DIR)/icrogue/engine/window/Button.java \
			  $(SRC_DIR)/icrogue/engine/window/Canvas.java \
			  $(SRC_DIR)/icrogue/engine/window/Image.java \
			  $(SRC_DIR)/icrogue/engine/window/Keyboard.java \
			  $(SRC_DIR)/icrogue/engine/window/Mouse.java \
			  $(SRC_DIR)/icrogue/engine/window/Sound.java \
			  $(SRC_DIR)/icrogue/engine/window/Window.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/ImageItem.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/Item.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/ShapeItem.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/SoundItem.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/SwingImage.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/SwingSound.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/SwingWindow.java \
			  $(SRC_DIR)/icrogue/engine/window/swing/TextItem.java \
			  $(SRC_DIR)/icrogue/handler/ICRogueInteractionHandler.java

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
