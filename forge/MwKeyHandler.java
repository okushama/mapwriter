package mapwriter.forge;

import java.util.EnumSet;

import mapwriter.Mw;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MwKeyHandler extends KeyHandler {

	private Mw mw;
	
	public static KeyBinding keyMapGui = new KeyBinding("key.mw_open_gui", Keyboard.KEY_M);
	public static KeyBinding keyNewMarker = new KeyBinding("key.mw_new_marker", Keyboard.KEY_INSERT);
	public static KeyBinding keyMapMode = new KeyBinding("key.mw_next_map_mode", Keyboard.KEY_N);
	public static KeyBinding keyNextGroup = new KeyBinding("key.mw_next_marker_group", Keyboard.KEY_COMMA);
	public static KeyBinding keyTeleport = new KeyBinding("key.mw_teleport", Keyboard.KEY_PERIOD);
	public static KeyBinding keyZoomIn = new KeyBinding("key.mw_zoom_in", Keyboard.KEY_PRIOR);
	public static KeyBinding keyZoomOut = new KeyBinding("key.mw_zoom_out", Keyboard.KEY_NEXT);
	
	private static KeyBinding[] keyBindings = new KeyBinding[] {
		keyMapGui, keyNewMarker, keyMapMode, keyNextGroup, keyTeleport, keyZoomIn, keyZoomOut};
	private static boolean[] keyBooleans = new boolean[] {
		false, false, false, false, false, false, false};
	
	public MwKeyHandler(Mw mw) {
		super(keyBindings, keyBooleans);
		this.mw = mw;
		
		// set localized names for the keys
		LanguageRegistry.instance().addStringLocalization("key.mw_open_gui", "en_US", "Open map GUI");
		LanguageRegistry.instance().addStringLocalization("key.mw_new_marker", "en_US", "New waypoint");
		LanguageRegistry.instance().addStringLocalization("key.mw_next_map_mode", "en_US", "Next map mode");
		LanguageRegistry.instance().addStringLocalization("key.mw_next_marker_group", "en_US", "Next waypoint group");
		LanguageRegistry.instance().addStringLocalization("key.mw_teleport", "en_US", "Teleport to waypoint");
		LanguageRegistry.instance().addStringLocalization("key.mw_zoom_in", "en_US", "Minimap zoom in");
		LanguageRegistry.instance().addStringLocalization("key.mw_zoom_out", "en_US", "Minimap zoom out");
	}

	@Override
	public String getLabel() {
		return "MapWriter Key Bindings";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (types.contains(TickType.CLIENT) && (tickEnd)) {
			this.mw.onKeyDown(kb);
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		// do nothing
	}

	@Override
	public EnumSet<TickType> ticks() {
		// keys should be handled in game in the client
		return EnumSet.of(TickType.CLIENT);
	}
	
}
