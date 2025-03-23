package me.Navoei.customdiscsplugin.language;

import org.bukkit.configuration.file.YamlConfiguration;

public enum Lang {
    PREFIX("prefix", "&8[&6CustomDiscs&8]&r"),
    PLAYER_NOT_FOUND("player-not-found", "&rPlayer not found!"),
    TOKEN_GRANTED_OTHER("token-granted-other", "&aToken granted to &7%player%&a!"),
    TOKEN_GRANTED("token-granted", "&aToken granted!"),
    NO_TOKEN("no-token", "&rYou do not have a token in your inventory."),
    NO_PERMISSION("no-permission", "&rYou do not have permission to execute this command."),
    INVALID_FILENAME("invalid-filename", "&rThis is an invalid filename!"),
    INVALID_FORMAT("invalid-format", "&rFile must be in wav, flac, or mp3 format!"),
    FILE_NOT_FOUND("file-not-found", "&rFile not found!"),
    INVALID_ARGUMENTS("invalid-arguments", "&rInsufficient arguments. &7(&a%command_syntax%&7)"),
    NOT_HOLDING_DISC("not-holding-disc", "&rYou must hold a disc in your main hand."),
    CREATE_FILENAME("create-filename", "&7Your filename is: &a\"%filename%\"."),
    CREATE_CUSTOM_NAME("create-custom-name", "&7Your custom name is: &a\"%custom_name%\"."),
    DOWNLOADING_FILE("downloading-file", "&7Downloading file..."),
    FILE_TOO_LARGE("file-too-large", "&rThe file is larger than %max_download_size%MB."),
    SUCCESSFUL_DOWNLOAD("successful-download", "&aFile successfully downloaded to &7%file_path%&a."),
    CREATE_DISC("create-disc", "&aCreate a disc by doing &7/cd create filename.extension \"Custom Lore\"&a."),
    DOWNLOAD_ERROR("download-error", "&rAn error has occurred while downloading."),
    NOW_PLAYING("now-playing", "&6Now playing: %song_name%"),
    DISC_CONVERTED("disc-converted", "&aConverted disc to new format! &fThis is due to changes in newer Minecraft versions which introduced &7JukeboxPlayableComponent&f."),
    INVALID_RANGE("invalid-range", "&rYou need to chose a range between 1 and %range_value%"),
    CREATE_CUSTOM_RANGE("create-custom-range", "&7Your range is set to: &a\"%custom_range%\"."),
    PORTABLE_PLAYER_CRAFTED("portable-player-crafted", "&aYou crafted portable player!"),
    NO_DISCS_IN_INVENTORY("no-discs", "&cThere`s no custom discs in your inventory!"),
    NOW_PLAYING_PORTABLE("now-playing-portable", "&6Playing: %song_name%"),
    STOPPED_PLAYING("stopped-playing", "&cPlaying paused!"),
    PLAYER_NOT_HOLDING_PLAYER("not-holding-player", "&cYou have to hold portable player!");

    private final String path;
    private final String def;
    private static YamlConfiguration LANG;

    /**
     * Lang enum constructor.
     *
     * @param path  The string path.
     * @param start The default string.
     */
    Lang(String path, String start) {
        this.path = path;
        this.def = start;
    }

    /**
     * Set the {@code YamlConfiguration} to use.
     *
     * @param config The config to set.
     */
    public static void setFile(YamlConfiguration config) {
        LANG = config;
    }

    @Override
    public String toString() {
        if (this == PREFIX)
            return LANG.getString(this.path, def) + " ";
        return LANG.getString(this.path, def);
    }

    public String replace(String placeholder, String replacement) {
        return this.toString().replace(placeholder, replacement);
    }

    /**
     * Get the default value of the path.
     *
     * @return The default value of the path.
     */
    public String getDefault() {
        return this.def;
    }

    /**
     * Get the path to the string.
     *
     * @return The path to the string.
     */
    public String getPath() {
        return this.path;
    }

    //Component textComponent = LegacyComponentSerializer.legacyAmpersand().deserialize(PlaceholderAPI.setPlaceholders(player, Lang.PREFIX + Lang.COMBAT.toString()));
    //player.sendMessage(textComponent);
}
